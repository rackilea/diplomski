List<String> tmp = new ArrayList<String>();

    do {
        ch = br.readLine();
        tmp.add(ch);
        out.print(ch+"<br/>"); 
    } while (ch != null);

    for(int i=tmp.size()-1;i>=0;i--) {
        out.print(tmp.get(i)+"<br/>");
    }