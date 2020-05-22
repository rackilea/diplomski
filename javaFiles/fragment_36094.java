TextArea ta = new TextArea();
    Scene scene = new Scene(ta);

    System.setOut(new PrintStream(new OutputStream() {

        @Override
        public void write(int b) throws IOException {
            ta.appendText("" + ((char)b));
        }

        @Override
        public void write(byte[] b) throws IOException {
            ta.appendText(new String(b));
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            ta.appendText(new String(b, off, len));
        }
    }));

    stage.setScene(scene);
    stage.show();
    System.out.println("THIS WILL BE WRITEN INSIDE THE TEXT AREA!");