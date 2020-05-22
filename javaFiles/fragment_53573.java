Processor proc = new Processor(false);
    XsltCompiler comp = proc.newXsltCompiler();
    XsltExecutable exp = comp.compile(new StreamSource(new File("my-stylesheet.xsl")));
    Serializer out = proc.newSerializer(new File("output.xml"));
    Xslt30Transformer trans = exp.load30();
    trans.applyTemplates(new StreamSource(new File("input.xml"), out);