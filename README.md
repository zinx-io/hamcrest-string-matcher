# hamcrest-string-matcher
Custom hamcrest matcher that counts occurances of a substring.

## Basic Usage
```
import static io.zinx.hamcrest.string.pattern.OccuranceMatcher.hasOccuranceCount;

...

    @Test
    public void testMatch() {
        String item = "Fred,Joe,John,Tim";
        String searchString = ",";
        int count = 3;

        assertThat(item, hasOccuranceCount(count, searchString));
    }

```

## Dependency
The code uses the Apache Commons Lang3 library.

## Building with Gradle
- Clone the repo from github.
- gradlew build

## Artifact available through Jitpack.io
The artifact is available on <https://jitpack.io/>.

#### Gradle
To include it using gradle, do the following:
```
	repositories {
	    maven {
	        url "https://jitpack.io"
	    }
	}
```

```
	dependencies {
	    compile 'com.github.zinx-io:hamcrest-string-matcher:0.0.3'
	}
```

#### Maven
To include it using maven, do the following:
```
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
```

```
	<dependency>
	    <groupId>com.github.zinx-io</groupId>
	    <artifactId>hamcrest-string-matcher</artifactId>
	    <version>0.0.3</version>
	</dependency>
```


