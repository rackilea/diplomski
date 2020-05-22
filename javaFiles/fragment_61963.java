try (BufferedOutputStream buffOut = new BufferedOutputStream(fo)) {
                int read;
                System.out.println("Beginning to copy...");
                while((read = buffIn.read()) != -1){
                    buffOut.write(read);
                }
            }