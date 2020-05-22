Processor saxon = new Processor(false);
    XQueryCompiler compiler = saxon.newXQueryCompiler();
    XQueryExecutable exec = compiler.compile(new File("query1.xq"));
    XQueryEvaluator query = exec.load(); 

    query.run(saxon.newSerializer(System.out));
    System.out.println();