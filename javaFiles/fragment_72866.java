while(line!=null) {
    if (!line.trim().isEmpty()){
        String s[]=line.split(",");
        if (s.length() >= 2) {
            String s1[]=s[1].split(";");
            if (s1.length() >= 2) {
                st[index]=s1[1];
                index++;
            }
            else 
                System.out.println("Missing semicolon");
        }
        else
            System.out.println("Missing comma");
    }
    line=br.readLine();
}