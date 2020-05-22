import com.sun.codemodel.*;
import com.sun.tools.xjc.*;
import com.sun.tools.xjc.api.*;

SchemaCompiler sc = XJC.createSchemaCompiler();
sc.setEntityResolver(new YourEntityResolver());
sc.setErrorListener(new YourErrorListener());
sc.parseSchema(SYSTEM_ID, element);
S2JJAXBModel model = sc.bind();