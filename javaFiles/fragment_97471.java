PrintWriter pw = new PrintWriter(new OutputStreamWriter(
                 new BufferedOutputStream(socket.getOuptutStream()), "UTF-8"));

pw.print( some text here );
pw.print( some more ext here );
pw.println( the end of the line );

pw.close(); // when finished.