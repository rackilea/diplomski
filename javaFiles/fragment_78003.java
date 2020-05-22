peopleDataFrame.toJavaRDD().map(
                                      new Function<Row, String>() {
                                          @Override
                                           public String call(Row row) throws Exception {
                                                String ins = null;
                                                ins = new TestClass().calc(row);
                                                }
                                            }
                                      });