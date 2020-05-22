Bridge.setVerbose(true);

    Bridge.init(new File("C:\\Users\\therka\\Desktop\\jar\\lib\\jni4net.n.w64.v40-0.8.3.0.dll"));

    Bridge.LoadAndRegisterAssemblyFrom(new java.io.File("C:\\Users\\therka\\Desktop\\jar\\lib\\Kratos_3.j4n.dll"));

    fsod = new FactSetOnDemand();