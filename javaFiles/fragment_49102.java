static void brute(String input, int depth, StringBuffer output) throws FileNotFoundException {

            if (depth == 0) {   
                System.out.println(output);

                PrintWriter pw =
                            new PrintWriter("/Users/evanlivingston/test.txt"); 
                pw.println(output); 
                pw.flush();
                pw.close();

            } else {
                for (int i = 0; i < input.length(); i++) {  
                    output.append(input.charAt(i));
                    brute(input, depth - 1, output);
                    output.deleteCharAt(output.length() - 1);    
                }

            }
        }