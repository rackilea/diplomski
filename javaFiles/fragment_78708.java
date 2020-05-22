import groovy.lang.GroovyClassLoader;

public class GroovyTest
{

    public static void main ( String [ ] argv ) throws Throwable
    {
            // Setting parent classloader!
            // also tried plain old "GroovyTest.class.getClassLoader()" as well
        GroovyClassLoader gcl = new GroovyClassLoader ( Thread.currentThread().getContextClassLoader() ) ;
        String src =
              "class Arf implements GroovyTest.Fooable { " + 
                 "public String foo ( ) { " + 
                   "return new GroovyTest.ThingyDoodle().doStuff('Arf');}}" ;
        Class clazz = gcl.parseClass(src, "AppleSauce.groovy");
        Object aScript = clazz.newInstance();
        Fooable myObject = (Fooable) aScript;
        System.out.println ( myObject.foo() ) ;
    }       
     public static interface Fooable { public String foo ( ) ; }

    public static class ThingyDoodle
    {
        public String doStuff ( String input )
        {
            return "Hi Worlds" ;
        }
    }


}