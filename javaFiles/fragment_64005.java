Socket s = new Socket("localhost", 8932);               
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

for (int i=0; i<20; i++) {
    bw.write(String.valueOf(i));
    bw.newLine();
    bw.flush();
    Thread.sleep(1000);
}
bw.close();