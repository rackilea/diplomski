root.setStartElementListener(new StartElementListener() {
            public void start(Attributes attributes) {
                foundElement = true;// tells you that you are parsing the intended xml
            }
        });

    nodeA.setEndTextElementListener(new EndTextElementListener() {
            public void end(String body) {
                //populate your pojo
            }
        });