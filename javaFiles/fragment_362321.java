import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.io.File;
import java.util.Properties;

class EnumGenerator{

    public EnumGenerator(
        File targetDir, 
        File propfile,
        File templateFile,
        String pkgName,
        String clsName 
    ) {
        def properties = new Properties();
        properties.load(propfile.newInputStream());
        def bodyText = generateBody( new TreeMap( properties) );
        def enumCode = templateFile.getText();
        def templateMap = [ body:bodyText, packageName:pkgName, className: clsName  ];
        templateMap.each{ key, value -> 
                                enumCode = enumCode.replace( "\${$key}", value ) } 
        writeToFile( enumCode, targetDir, pkgName, clsName )
    }

    void writeToFile( code, dir, pkg, cls ) {
        def parentDir = new File( dir, pkg.replace('.','/') )
        parentDir.mkdirs();
        def enumFile = new File ( parentDir, cls + '.java' )
        enumFile.write(code)
        System.out.println( "Wrote file $enumFile successfully" )
    }

    String generateBody( values ) {

        // create constructor call PROPERTY_KEY("value")
        // from property.key=value
        def body = "";
        values.eachWithIndex{
            key, value, index ->
                body += 
                ( 
                    (index > 0 ? ",\n\t" : "\t")
                    + toConstantCase(key) + '("' + value + '")'
                )   
        }
        body += ";";
        return body;

    }

    String toConstantCase( value ) {
        // split camelCase and dot.notation to CAMEL_CASE and DOT_NOTATION
        return Arrays.asList( 
            value.split( "(?:(?=\\p{Upper})|\\.)" ) 
        ).join('_').toUpperCase();
    }

}