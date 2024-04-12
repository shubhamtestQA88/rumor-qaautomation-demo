## Rumor - QA Automation Demo

## Technical Evaluation Test For QA Engineer

#### [Demo Video - Test Execution through Eclipse](https://vimeo.com/933638517?share=copy) 

#### [Demo Video - Test Execution through Maven commands](https://vimeo.com/933638480?share=copy) 

### Tools & Technologies Used

- Java Development Kit (JDK) (Version 17)
- Maven Dependency management (3.0.0)
- Selenium WebDriver (4.16.0) 
- TestNG (6.14.3)


## Task 1: Write Test Scripts

### Setup Guide

### Prerequisites
- Java Development Kit (JDK) – Version 17: [Download JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- Maven - Dependency management: [Download Maven](https://maven.apache.org/download.cgi)
- Selenium WebDriver - For browser automation: [Download Selenium](https://www.selenium.dev/downloads/)

### Installation (Windows)
#### Step 1:. **Clone the repository**
git clone <repository-url>

#### Step 2. **Install Maven on your system**
- Find Your Maven Installation Directory:  
  For example, if you extracted Maven to `C:\Program Files\apache-maven-3.9.6`, then that's your Maven installation directory.
- Edit the System Environment Variables:
  - Update the PATH Variable:
    - In the Environment Variables window, under the "System variables" section, find the Path variable and select it.
    - Click "Edit".
    - In the Edit Environment Variable window, click "New" and add the path `C:\Program Files\apache-maven-3.9.6\bin` to the bin directory of your Maven installation.
- **Verify the Maven Installation:**
  ```
  mvn -v
  ```
#### Step 3. **Run the Tests**
mvn test


### Testing Approach
Our data-driven test framework simplifies test maintenance and allows for easy updates as the application changes.

### 1. Test Data Source:

#### Tools:
  -  Excel/CSV: Commonly used formats for storing test data due to their simplicity and accessibility.

#### Technologies:
  -  Apache POI/HSSF & XSSF: Libraries in Java for reading and writing Excel files.

### 2. Test Script:

#### Tools:
  -  Selenium: A powerful tool for automating web browsers, allowing scripts to interact with web pages dynamically.
  -  TestNG: A testing framework that supports data-driven testing through annotations, making it easier to integrate with Selenium.

#### Technologies:
  -  Java: Often used for writing test scripts in Selenium with TestNG due to its robust ecosystem and extensive library support.

### 3. Test Runner:

#### Tools:
  -  TestNG: Not only supports writing test cases but also manages their execution in a data-driven manner by iterating over provided datasets.

#### Technologies:
  -  Maven : These build tools can be configured to run TestNG suites, handling dependencies, and executing tests across different environments.

### 4. Test Reports:

#### Tools:
  -  TestNG Reports: TestNG frameworks generate detailed reports that outline the test results, including pass/fail statuses.

#### Technologies:
  -  Extent Reports: A flexible reporting tool that can be integrated with Selenium and TestNG to produce more visually detailed reports.



## Task 2: Debugging Challenge

### Analysis and Solutions for Handling Flaky Tests
As we know, Flaky tests are automated tests that exhibit both passing and failing outcomes under the same configuration.

**Common Causes and Proposed Solutions:**
- **Cause 1:** Asynchronous operations can cause flaky tests if elements are interacted with before they're loaded.
    - **Solution:** Use explicit waits (e.g., WebDriverWait) to ensure elements are in the desired state before interaction.
 ```java
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("someElementId")));
 ```
- **Cause 2:** UI changes (identifiers, layouts, styles) can break tests with fragile selectors.
    - **Solution:** Prioritize stable identifiers (id, data-test-id) and avoid complex XPath selectors. Collaborate with developers to ensure critical elements are identifiable for testing.
- **Cause 3:** Test order dependencies can cause flakiness in parallel execution.
    - **Solution:** Design tests to be independent, avoiding reliance on specific execution order.
- **Cause 4:** Environmental differences (browsers, APIs, dependencies) can cause test flakiness.
    - **Solution:** Regularly update tests to reflect the application's current state. Integrate tests into CI for consistent execution.

