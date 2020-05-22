try {
                            myRecorder.prepare();
                            myRecorder.start();
                        } catch (IllegalStateException e) {
                            // start:it is called before prepare()
                            // prepare: it is called after start() or before setOutputFormat()
                            e.printStackTrace();
                        } catch (IOException e) {
                            // prepare() fails
                            e.printStackTrace();
                        }