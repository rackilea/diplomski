reader = new BufferedReader(fr);
                String next, line = reader.readLine();
                for (boolean first = true, last = (line == null); !last; first = false, line = next) {
                    last = ((next = reader.readLine()) == null);


                    if (first) {

                        header=line;
                        System.out.println("First Line : "+header);


                    } else if (last) {

                        footer=line;
                        System.out.println("Middle Line : "+footer);



                    } else {

                        middle=line;
                        System.out.println("Footer Line : "+middle);



                    }

                    //WriteBUlkFileWithDifferenttemplates(header,middle,footer);

                }System.out.println("\n \n");
            } finally {
                if (reader != null) try { reader.close(); } catch (IOException logOrIgnore) {}
            }





        }