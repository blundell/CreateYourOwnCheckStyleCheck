CreateYourOwnCheckStyleCheck
============================

Contains two projects

 - **TestProject** contains the poorly written Java code that will have checkstyle ran on it

 - **BlundellCheckstyle** contains the custom checkstyle checks that have been written


How to run checkstyle :

 - from a Terminal
 - go into the TestProject folder
 - run mvn checkstyle:checkstyle
 - output will be generated in /target/
