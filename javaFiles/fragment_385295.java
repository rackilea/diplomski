DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();

        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            exec.submit(new Runnable() {
                public void run() {
                    try {
//                        synchronized (builder) {
                            InputSource is = new InputSource(new StringReader("<?xml version=\"1.0\" encoding=\"UTF-8\" ?><俄语>данные</俄语>"));
                            builder.parse(is);
                            builder.reset();
//                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        exec.shutdown();