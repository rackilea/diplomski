class X
    bar()
        // new Y();

        Class classY = currentLoader.loadClass("Y");
        Constructor cst = classY.getConstructor();

        // next line will initialize Y (if not yet)
        // creating an instance of a class requires it be initialized
        Object y = cst.newInstance();