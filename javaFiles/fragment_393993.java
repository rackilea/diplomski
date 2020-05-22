Updating the PATH Environment Variable

If you do not set the PATH variable, you need to specify the full path to the executable file every time you run it, such as:

C:\> "C:\Program Files\Java\jdk1.8.0\bin\javac" MyClass.java

It is useful to set the PATH variable permanently so it will persist after rebooting.

To set the PATH variable permanently, add the full path of the jdk1.8.0\bin directory to the PATH variable. Typically, this full path looks something like C:\Program Files\Java\jdk1.8.0\bin. Set the PATH variable as follows on Microsoft Windows:

    Click Start, then Control Panel, then System.    
    Click Advanced, then Environment Variables.

    Add the location of the bin folder of the JDK installation to the PATH variable in System Variables. The following is a typical value for the PATH variable:

    C:\WINDOWS\system32;C:\WINDOWS;C:\Program Files\Java\jdk1.8.0\bin

Note:

    The PATH environment variable is a series of directories separated by semicolons (;) and is not case-sensitive. Microsoft Windows looks for programs in the PATH directories in order, from left to right.    
    You should only have one bin directory for a JDK in the path at a time. Those following the first instance are ignored.    
    If you are not sure where to add the JDK path, append it.    
    The new path takes effect in each new command window you open after setting the PATH variable.