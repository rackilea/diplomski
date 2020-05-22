try {

                PrintWriter write = new PrintWriter(output);
                String text = input.nextLine();
                write.println(text) // also tried 
                                    // write.println(input.nextLine());
                write.close();

            } catch (Exception e) {

                System.out.println("Exception found");
            }