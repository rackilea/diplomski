InputStream io =(getClass().getClassLoader().getResourceAsStream("/mario/crediti/ringraziamenti.txt"));
BufferedReader br = new BufferedReader(new InputStreamReader(io));

String temp;
while((temp = br.readLine()) != null){
    System.out.println(""+temp);
}