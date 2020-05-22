Process proc = Runtime.getRuntime().exec(new String[]{"gpg",
                                                      "--recipient",
                                                      "testKey2014",
                                                      "--output",
                                                      csvFilePath + ".gpg",
                                                      "--encrypt"
                                                      csvFilePath});