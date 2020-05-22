File f = new File("E:\\NEw_Workspace\\Voice_recognition_modify\\src\\edu\\cmu\\sphinx\\demo\\helloworld\\hello.gram");
                    RandomAccessFile raf = new RandomAccessFile(f, "rw");

                    // Read a character
                   // char ch = raf.readChar();

                    // Seek to end of file
                    raf.seek((f.length())-1);

                    // Append to the end
                    raf.write(("|(KARAN);").getBytes());

                    raf.close();
                } catch (IOException e) {
                }