ProcessBuilder pb = new ProcessBuilder(args);
pb.redirectError();
Process p = pb.start();

InputStream is = p.getInputStream();
int in = -1;
while ((in = is.read()) != -1) {
    System.out.print((char)in);
}

int processCompleted = p.waitFor();