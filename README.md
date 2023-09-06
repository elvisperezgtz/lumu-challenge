# Web Automation Project with Serenity BDD and Gradle

This project is a web test automation challenge using Serenity BDD and Selenium as the automation framework, Gradle as the build system and Java 17 as the programming language.

## Prerequisites

- Java JDK 17 or higher installed on your system.
- Gradle installed on your system.

## Project Structure

The project structure follows the conventions of a standard Gradle project with specific configuration for Serenity BDD. Below are descriptions of key directories:

- **src/test/java:** Contains test classes written in Java using the Screenplay pattern.
- **src/test/resources:** Contains resource files necessary for tests, such as data files and configuration files.
- **build.gradle:** The Gradle build file that defines dependencies and build tasks.

## Running the Tests

You can run the tests using the following Gradle command:

```bash
gradle clean test
```
## Test report
You can see the  [Serenity report](target/site/serenity/index.html)