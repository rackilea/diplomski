try {
   fw = new FileWriter(f.getAbsoluteFile());
   BufferedWriter bw = new BufferedWriter(fw);
 } catch (IOException e) {
   System.out.println(f.getAbsoluteFile());
 }
 BufferedWriter bw = new BufferedWriter(fw);