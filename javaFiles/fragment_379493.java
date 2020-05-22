Reader in = new FileReader(args[0]);
    Writer out = new FileWriter("output.doc");
    BufferedReader br = new BufferedReader(in);
    String str;
    while((str=br.readLine())!=null){
        out.write(str);
        System.out.println(str.getBytes());
    }
    out.close();