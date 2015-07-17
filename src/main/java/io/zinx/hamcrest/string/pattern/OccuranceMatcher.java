/**
 * Copyright 2015 zinx.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.zinx.hamcrest.string.pattern;

/**
 * Created by wfleming on 7/16/15.
 */

import org.apache.commons.lang3.StringUtils;

import org.hamcrest.Factory;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;


public class OccuranceMatcher extends TypeSafeMatcher<String> {

    private final String searchString;
    private final int count;


    public OccuranceMatcher(int count, String searchString) {
        this.count = count;
        this.searchString = searchString;
    }


    @Override
    protected boolean matchesSafely(String item) {
        int countInItem = StringUtils.countMatches(item, searchString);
        return count == countInItem;
    }


    @Override
    public void describeTo(Description description) {
        description.appendText("String contains ")
                .appendValue(count)
                .appendText(" occurances of ")
                .appendValue(searchString);
    }


    @Override
    protected void describeMismatchSafely(String item, Description mismatchDescription) {
        mismatchDescription.appendValue(item)
                .appendText(" contains ")
                .appendValue(StringUtils.countMatches(item, searchString))
                .appendText(" occurance(s) of ")
                .appendValue(searchString);
    }


    @Factory
    public static <T> Matcher<String> hasOccuranceCount(int occuranceCount, String text) {
        return new OccuranceMatcher(occuranceCount, text);
    }

}


