-injars       application.jar        # obfuscate all the classes in the named jars
-outjars      obfuscated.jar         # save all the obfuscated classes to the named jar
-libraryjars  <java.home>/lib/rt.jar # these are all the libraries that the application uses
-printmapping obfuscation.map        # save a file linking the original names to the obfuscated ones
                                     # this helps understanding stack traces from the obfuscated application

# we need to keep our main class and the application entry point
-keep public class com.mycompany.Application {
    public static void main(java.lang.String[]);
}