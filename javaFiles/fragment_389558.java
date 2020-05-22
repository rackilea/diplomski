while ((line = in.readLine()) != null) {
    System.out.println(line);
    bw.write(line+"\n");
    bw.flush();
    bw.close(); // <- Problem
}