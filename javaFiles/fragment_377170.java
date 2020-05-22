public static void main(String[] args) throws IOException {             
    Scanner in = new Scanner(new FileReader("C:\\a.txt"));
    StringBuilder sb = new StringBuilder();
    while(in.hasNext()) {
        String s=in.nextLine();
        if (s.equals(""))               
           sb.append(System.lineSeparator());
        else
            sb.append(s);           
    }
    in.close();
    System.out.println( sb.toString());
    }