ServerSocket s = new ServerSocket(4444);

Socket incoming = s.accept();

OutputStream output = s.getOutputStream();

PrintWriter pw = new PrintWriter(output,true);

System.out.println(pw.write(new Scanner(System.in).nextLine()));