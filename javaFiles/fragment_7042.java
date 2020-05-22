import com.sun.codemodel.*;
import com.sun.tools.xjc.api.*;
import org.xml.sax.InputSource;

// Configure sources & output
String schemaPath = "path/to/schema.xsd";
String outputDirectory = "schema/output/source/";

// Setup schema compiler
SchemaCompiler sc = XJC.createSchemaCompiler();
sc.forcePackageName("com.xyz.schema.generated");

// Setup SAX InputSource
File schemaFile = new File(schemaPath);
InputSource is = new InputSource(new FileInputStream(schemaFile));
is.setSystemId(schemaFile.getAbsolutePath());

// Parse & build
sc.parseSchema(is);
S2JJAXBModel model = sc.bind();
JCodeModel jCodeModel = model.generateCode(null, null);
jCodeModel.build(new File(outputDirectory));