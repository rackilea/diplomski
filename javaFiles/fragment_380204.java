Use for writing object       
ObjectOutputStream  outputStream = new ObjectOutputStream(new 
                        FileOutputStream(new File("test")));



Use it for appending object at end of file 
ObjectOutputStream outputStream2 = new ObjectOutputStream(new FileOutputStream("test", true)) {
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };