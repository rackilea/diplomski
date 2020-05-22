String[] dummyArgs = {"--vanilla"};
    REngine eng = REngine.engineForClass("org.rosuda.REngine.JRI.JRIEngine", dummyArgs, new REngineStdOutput (), false); // debug mode, print R-trace in Java

    String[] colNames = {"col1", "col2", "col3"};
    String[] col1 = {"a1", "a2", "a3", "a4"};
    String[] col2 = {"b1", "b2", "b3", "b4"};
    int[] col3 = {1, 2, 3, 4};

    REXP mydf = REXP
                .createDataFrame(new RList(
                        new REXP[] {
                                new REXPString(col1),
                                new REXPString(col2),
                                new REXPInteger(col3)},
                        colNames));

    eng.assign("myDataFrame", mydf);

    eng.parseAndEval("print(myDataFrame)");