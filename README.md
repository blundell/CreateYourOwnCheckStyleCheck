CreateYourOwnCheckStyleCheck
============================

<h3>Contains two projects</h3>

 - **TestProject** contains the poorly written Java code that will have checkstyle ran on it

 - **BlundellCheckstyle** contains the custom checkstyle checks that have been written

<h3>How it works</h3>

 - **TestProject** uses the maven-checkstyle-plugin
 - the maven-checkstyle-plugin has a dependency on **BlundellCheckStyle**
 - **BlundellCheckstyle** is where we create the custom checks
 - the maven-checkstyle-plugin then uses a *checkstyle-configuration.xml* file to declare what checks we want checkstyle to run
 - within checkstyle-configuration.xml we declare our custom checks from **BlundellCheckStyle**


<h3>How to run checkstyle</h3>

 - from a Terminal
 - run mvn install
 - go into the TestProject folder
 - run mvn checkstyle:checkstyle
 - open up target/site/checkstyle.html to see style errors