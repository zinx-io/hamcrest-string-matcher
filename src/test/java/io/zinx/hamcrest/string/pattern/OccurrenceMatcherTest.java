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

import org.junit.Test;

import static io.zinx.hamcrest.string.pattern.OccurrenceMatcher.hasOccurrenceCount;

import static org.junit.Assert.fail;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by wfleming on 7/16/15.
 */

public class OccurrenceMatcherTest {

    @Test
    public void testMatch() {
        String item = "Fred,Joe,John,Tim";
        String searchString = ",";
        int count = 3;

        assertThat(item, hasOccurrenceCount(count, searchString));
    }


    @Test
    public void testWrongCount() {
        String item = "Fred,Joe,John,Tim";
        String searchString = ",";
        int count = 4;

        int actualCount = 3;

        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append("\nExpected: String contains <").append(count)
                .append("> occurrence(s) of \"").append(searchString).append("\"\n     but: \"").append(item)
                .append("\" contains <").append(actualCount).append("> occurrence(s) of \"").append(searchString).append("\"");

        try {
            assertThat(item, hasOccurrenceCount(count, searchString));
        } catch (AssertionError e) {
            assertTrue(e.getMessage().startsWith(expectedMessage.toString()));
            return;
        }

        fail("should have failed");
    }


    @Test
    public void testZeroCount() {
        String item = "Fred,Joe,John,Tim";
        String searchString = ",";
        int count = 0;

        int actualCount = 3;

        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append("\nExpected: String contains <").append(count)
                .append("> occurrence(s) of \"").append(searchString).append("\"\n     but: \"").append(item)
                .append("\" contains <").append(actualCount).append("> occurrence(s) of \"").append(searchString).append("\"");

        try {
            assertThat(item, hasOccurrenceCount(count, searchString));
        } catch (AssertionError e) {
            assertTrue(e.getMessage().startsWith(expectedMessage.toString()));
            return;
        }

        fail("should have failed");
    }


    @Test
    public void testNullItem() {
        String item = null;
        String searchString = ",";
        int count = 3;

        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append("\nExpected: String contains <").append(count)
                .append("> occurrence(s) of \"").append(searchString).append("\"\n     but: ").append("was null");

        try {
            assertThat(item, hasOccurrenceCount(count, searchString));
        }
        catch (AssertionError e) {
            assertTrue(e.getMessage().startsWith(expectedMessage.toString()));
            return;
        }

        fail("should have failed");
    }


    @Test
    public void testNullSearch() {
        String item = "Fred,Joe,John,Tim";
        String searchString = null;
        int count = 3;

        int actualCount = 0;

        StringBuilder expectedMessage = new StringBuilder();
        expectedMessage.append("\nExpected: String contains <").append(count)
                .append("> occurrence(s) of ").append("null").append("\n     but: \"").append(item)
                .append("\" contains <").append(actualCount).append("> occurrence(s) of ").append("null");

        try {
            assertThat(item, hasOccurrenceCount(count, searchString));
        } catch (AssertionError e) {
            assertTrue(e.getMessage().startsWith(expectedMessage.toString()));
            return;
        }

        fail("should have failed");
    }




}


