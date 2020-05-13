[![Gitter](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/vaadin/framework-8?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge)

# Vaadin Framework

*[Vaadin Framework](https://vaadin.com) allows you to build modern web apps efficiently in plain Java, without touching low level web technologies.*

This repository contains source code and issue tracking for Vaadin 8 and Vaadin 7, both of which use GWT as the base of client-side implementations. You can find source code and issue tracking for newer, web component based Vaadin versions in [vaadin/platform](https://github.com/vaadin/platform).

Vaadin 8 includes Vaadin 7 compatibility classes and is supported until February 21, 2022 (extended support will be available for ten years after that).

Vaadin 7 support has already ended, [extended support](https://vaadin.com/support/vaadin-7-extended-maintenance) is available until February 2029.

For instructions about _using_ Vaadin 8 to develop applications, please refer to [Vaadin tutorial](https://vaadin.com/docs/v8/framework/tutorial.html) and other [documentation](https://vaadin.com/docs/v8/index.html).

To contribute, first refer to [Contributing Code](https://github.com/vaadin/framework/blob/master/CONTRIBUTING.md)
for general instructions and requirements for contributing code to the Vaadin framework.

Instructions on how to set up a working environment for developing the Vaadin Framework follow below.

## Building a package

The distribution files can be built by running the standard Maven goal `mvn install` in the project root.

## Eclipse Quick Setup

1. Decide were you would like your Eclipse workspace to be located.
    * This project contains multiple modules and uses configurations that might clash with your existing projects, using a separate workspace is recommended.
    * Eclipse Oxygen is recommended, different versions may treat formatting rules differently.
    * If you are using Windows, you may wish to keep the workspace path reasonably short (e.g. `C:\dev\<workspaceName>`) to avoid problems with too long file paths.
1. Start Eclipse with your chosen workspace and [set up extra workspace preferences](#set-up-extra-workspace-preferences).
1. Clone the repository within your selected workspace using Eclipse's clone wizard, using your favorite Git tool, or in command-line running
<code>git clone https://github.com/vaadin/framework.git</code> command.
    * Eclipse's clone wizard can be found within Git perspective (*Window* -> *Perspectives* -> *Open Perspective* -> *Git*). _Only_ clone the project at this stage, do not let the clone wizard import projects as well.
    * If using Windows, you might also want to add these Git settings: `core.autocrlf=false` and `core.fileMode=false`. You can do this in Eclipse by right-clicking the repository in Git perspective, clicking *Properties*, then *Add Entry...* and using key `core.autocrlf` and value `false` etc.
    * If too long file paths become a problem you may also need `core.longpaths=true`.
1. Import the project into Eclipse as a Maven project. Use *File* -> *Import* -> *Maven* -> *Existing Maven Projects*.
1. Select the *framework* folder (where you cloned the project).
    * It is not necessary to import all the modules, but it is recommended to include at least the root module, `vaadin-uitest` module, and any modules you may wish to make changes to. You can import more modules when needed by repeating these last steps.
1. Click “Finish” to complete the import of Vaadin Framework.

### Set up extra workspace preferences

Certain preferences and save actions need to be set to keep the project formatting consistent. You need to do this especially if you wish to be able to contribute changes to the project.

For instructions please visit [README-WORKSPACE.md](README-WORKSPACE.md).

### Getting started

Run <code>install</code> maven goal for the project root to get started.
In Eclipse this is done by right-clicking on the project root in Project Explorer and choosing *Run As* -> *Maven Build...*. If you choose to skip tests you may need to run the <code>install</code> maven goal for `vaadin-uitest` project separately.
* Note that the first compilation takes a while to finish as Maven downloads dependencies used in the projects.
* In some Windows environments the compilation doesn't respect the `core.autocrlf=false` and the workspace preferences listed in the previous section, and running <code>install</code> converts all line endings from six core projects (root, `vaadin-client`, `vaadin-server`,  `vaadin-shared`, `vaadin-testbench-api`, `vaadin-uitest`) to Windows-style. As a quick-and-dirty workaround you can change the line endings back through *File* -> *Convert Line Delimiters To* -> *Unix* and comment out references to plugins `net.revelc.code.formatter` and `com.github.dantwining.whitespace-maven-plugin` from each affected module's pom.xml (root project references them twice) to prevent it from happening again. *Do not* include those changes or any files with Windows-style line endings in any pull request. Because you consequently lose the formatting benefits of those plugins, you also need to be more careful about not including irrelevant formatting changes in your commits.

Now the project should compile without further configuration.

### Compiling the Default Widget Set and Themes

* Compile the default widgetset by running <code>install</code> maven goal in `vaadin-client-compiled` module root.
In Eclipse this is done by right clicking on `vaadin-client-compiled` project in Project Explorer and choosing *Run As* -> *Maven Build...*.
You don't need to do this separately if you have already run <code>install</code> for the root project after your latest changes. 
* Compile the default themes by running <code>install</code> maven goal in `vaadin-themes` module root.
In Eclipse this is done by right clicking on `vaadin-themes` project in Project Explorer and choosing *Run As* -> *Maven Build...*.
You don't need to do this separately if you have already run <code>install</code> for the root project after your latest changes.

### Running a UI test

#### Using DevelopmentServerLauncher (recommended)
1. In a Project Explorer navigate to *vaadin-uitest/src/main/java/com/vaadin/launcher*
1. Right-click file DevelopmentServerLauncher.java
1. Open *Run As* -> *Java Application*
1. Open URL [http://localhost:8888/run/&lt;testUI&gt;](http://localhost:8888/run/<testUI>)

#### Using Jetty
1. In a Project Explorer right-click *vaadin-uitest*
1. Open *Run As* -> *Maven build...*
1. Type in <code>jetty:run-exploded</code> into *Goals* and click *Run*
1. Open URL [http://localhost:8888/run/&lt;testUI&gt;](http://localhost:8888/run/<testUI>)

For full instructions please visit [README-TESTS.md](README-TESTS.md).

## Setting up IntelliJ IDEA to Develop Vaadin Framework 8

1. Install and run IDEA. Ultimate Edition is better but Community Edition should also work.
1. Ensure if Git and Maven plugins are installed, properly configured and enabled.
1. Clone the repository, using menu VCS -> Checkout from Version Control -> Git -> Git Repository URL -> https://github.com/vaadin/framework.git.
  When the repository is cloned, do **NOT** open it as a project.
1. Open cloned repository as a maven object. Use File -> Open and choose root _pom.xml_ file
1. Have a coffee break while IDEA is loading dependencies and indexing the project
1. Run Maven targets <code>clean</code> and <code>install</code> using *Maven Projects* tool window to compile the whole project

### Running a specific UI test

1. Open *Maven Projects*
1. Open *vaadin-uitest* -> *Plugins* -> *jetty* -> *jetty:run-exploded*
1. Open URL [http://localhost:8888/run/&lt;testUI&gt;](http://localhost:8888/run/<testUI>)

For full instructions please visit [README-TESTS.md](README-TESTS.md).

### Running a Development Server

1. Open *Run* menu  and click *Edit Configurations*
1. Click green ***+*** sign at top left corner, select *Maven* from popup
1. In the run configuration page, set any name for the configuration, select *vaadin-uitest* project folder as *Working directory*
1. Type <code>exec:exec@run-development-server</code> into *Command line* and save the configuration
1. Run the configuration and open URL [http://localhost:8888/run/&lt;testUI&gt;](http://localhost:8888/run/<testUI>)

### Running a Development Server in a debug mode

1. Type <code>exec:exec@debug-development-server</code> into *Command line* and save the configuration
1. In the same dialog, create new "Remote" debug configuration, using *localhost* and *Port 5005*
1. Start both configurations and open URL [http://localhost:8888/run/&lt;testUI&gt;](http://localhost:8888/run/<testUI>)
