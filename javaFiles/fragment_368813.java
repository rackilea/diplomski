PrintWriter out = new PrintWriter(new BufferedWriter(
                                  new OutputStreamWriter(System.out, "UTF-8")));

// call many times
out.print(num);

// to flush the buffer so all the data can be read.
out.flush();