JCodeModel jCodeModel = createJCodeModel(); // create and prepare JCodeModel 
ByteArrayOutputStream baos = new ByteArrayOutputStream();
CodeWriter codeWriter = new SingleStreamCodeWriter(baos);
jCodeModel.build(codeWriter);

String code = baos.toString(); // you can use toString(charset) if there are special characters in your code