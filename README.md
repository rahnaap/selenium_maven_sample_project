# Selenium Webdriver with java Sample project 
In this sample project I automated Salesforce [https://www.salesforce.com/ap/hub/sales/] with few testcases parallelly as it reduce the total time to finish the test.  I deliberately put one testcase to failed inorder to showcase failure screenshot. Screenshot is captured by using TestNg listeners. This screenshot also attached to the extent report. Screenshot and extent report can be found at the reports directory [reports/index.html]. 
# Sample test cases in this project 
- home page [Used data provider inorder to run testcases with different parameters]
- Validate Title 
- Validate Navigation bar [2 test scenarios]
# Technolgies uses 
 - Java
 - Selenium
 - Maven
 - TestNg
 - PageObject Design pattern
 - Log4J
 - Extent Report
# IDE
- Eclipse
# Prerequisite
- Configure Java
- Install and configure Eclipse / Any IDE
- Donwlod and configure Chrome driver in the project [your chrome browser and chrome driver should be the same version]
- /src/main/java/resources/BaseData.java Edit line:37 with your chrome drive path
# How to run
```sh
$ git clone https://github.com/rahnaap/selenium_maven_sample_project.git
$ cd selenium_maven_sample_project.git
$ mvn test 
```
You can also import the same project in your Eclipse IDE and run from there. 
  
# License
MIT
