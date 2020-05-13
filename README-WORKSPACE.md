# Setting up extra workspace preferences in Eclipse

The following preferences need to be set to keep the project consistent. You need to do this especially to be able to contribute changes to the project.

## General

1. Open *Window* -> *Preferences* (Windows) or *Eclipse* -> *Preferences* (Mac)
1. Go to *General* -> *Workspace*
   - Set *Text file encoding* to *UTF-8*
   - Set *New text file line delimiter* to *Unix*
1. Go to *XML* -> *XML Files* -> *Editor*
   - Ensure the settings are follows:
     - Line width: 72
     - Format comments: true
     - Join lines: true
     - Insert whitespace before closing empty end-tags: true
     - Indent-using spaces: true
     - Indentation size: 4
1. Go to *Java* -> *Compiler* -> *Errors*
   - Switch *Serializable class without serialVersionUID* to *Ignore*
1. Go to *Java* -> *Installed JREs*
   - Select a Java 8 JDK as the default

## Configuration files

1. Open *Window* -> *Preferences* (Windows) or *Eclipse* -> *Preferences* (Mac)
1. Go to *Java* -> *Code Style* -> *Clean Up*
   - Import /eclipse/VaadinCleanup.xml
1. Go to *Java* -> *Code Style* -> *Formatter*
   - Import /eclipse/VaadinJavaConventions.xml

## Save Actions

1. Open *Window* -> *Preferences* (Windows) or *Eclipse* -> *Preferences* (Mac)
1. Go to *Java* -> *Editor* -> *Save Actions*
   - Check *Perform the selected actions on save*
      - Check *Format source code*
        - Select *Format edited lines*
   - Check *Organize imports*
   - Check *Additional actions*
   - Click *Configure*
     1. In tab *Code Organizing*
        - Check *Remove trailing whitespace*
          - Select *All lines*
        - Uncheck everything else
     1. In tab *Code Style*
        - Check *Use blocks in if/while/for/do statements*
          - Select *Always*
        - Uncheck everything else
     1. In tab *Member Accesses*
        - Check *Use 'this' qualifier for field accesses*
          - Select *Only if necessary*
        - Check *Use 'this' qualifier for method accesses*
          - Select *Only if necessary*
        - Uncheck everything else
     1. In tab *Missing Code*
        - Check *Add missing Annotations*
          - Check *'@Override'*
            - Check *Implementations of interface methods (1.6 or higher)*
          - Check *'@Deprecated'*
     1. In tab *Unnecessary Code*
        - Check *Remove unused imports* and *Remove unnecessary casts*, uncheck everything else.
     1. Click *OK*

After that is done, you should have 9 of 28 save actions activated and listed as such:

* Remove 'this' qualifier for non static field accesses
* Remove 'this' qualifier for non static method accesses
* Convert control statement bodies to block
* Remove unused imports
* Add missing '@Override' annotations
* Add missing '@Override' annotations to implementations of interface methods
* Add missing '@Deprecated' annotations
* Remove unnecessary casts
* Remove trailing white spaces on all lines

## About committing changes

Despite our best efforts the formatting options aren't always entirely consistent between different development environments, and sometimes we miss inconsistent formatting during code review. When you commit your changes for a pull request, try to make sure that the commit _only contains changes that are relevant to your patch,_ or at least closely affiliated with the relevant changes. Random formatting changes all over the changed file(s) make it difficult to grasp the main purpose of your change(s).
