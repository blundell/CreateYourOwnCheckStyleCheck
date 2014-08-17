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


<h3>Current Limitations</h3>

 - in *checkstyle-configuration.xml* we have to use the full package of the check *com.blundell.checks.AntiHungarian*
 - this can be fixed by declaring a *checkstyle-packages.xml* **this currently doesn't work**


*checkstyle-packages.xml* would looks something like this:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE checkstyle-packages PUBLIC
  "-//Puppy Crawl//DTD Package Names 1.0//EN"
  "http://www.puppycrawl.com/dtds/packages_1_0.dtd">

<checkstyle-packages>
  <package name="com.blundell.checks">
</checkstyle-packages>
```
     
and you would add it to the maven-checkstyle-plugin declaration

    // There are multiple ways to try this, I haven't found one that works
    // so I do not want to document it here

then your checkstyle-configuration.xml would not need the package:

```xml
<?xml version="1.0"?>
<!DOCTYPE module PUBLIC
    "-//Puppy Crawl//DTD Check Configuration 1.2//EN"
    "http://www.puppycrawl.com/dtds/configuration_1_2.dtd">

<module name="Checker">
  <module name="TreeWalker">
    <!-- Blundell specific checks -->
    <module name="AntiHungarian" />
  </module>
</module>
```
