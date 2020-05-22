try (BufferedReader br = new BufferedReader(new FileReader("MyFile.txt")))
                {

                    String sCurrentLine;

                    while ((sCurrentLine = br.readLine()) != null) {
                        document.add(new Paragraph(sCurrentLine));
                    }

                } catch (IOException exception) {
                    exception.printStackTrace();
                }