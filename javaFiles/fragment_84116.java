SendToHostClass(int sizeBufferConf) {
    sizeBuffer = sizeBufferConf;
    parameterList = new ParameterClass[sizeBuffer];

    for (int i = 0; i < sizeBuffer; i++) {
        parameterList[i] = new ParameterList();
    }
  }