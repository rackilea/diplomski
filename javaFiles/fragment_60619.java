File f=new File("test.css");
        BufferedReader br=new BufferedReader(new FileReader(f));
        String ln;
        StringBuffer sb=new StringBuffer();
        while((ln=br.readLine())!=null){
            sb.append(ln);
        }
        String[] sections=sb.toString().split("}");
        for(String st:sections){
            String temp=st.substring(st.indexOf("-")+1, st.indexOf(":")).toUpperCase()+"("+st.substring(st.indexOf("\\")+1, st.indexOf("\";"))+")";
            System.out.println(temp);
        }