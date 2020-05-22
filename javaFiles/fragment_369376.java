File f = new File("output.txt");
    try {
        Scanner s = new Scanner(f);
        String line = "";
        while(s.hasNext()){
            line=s.nextLine();
            if(line.startsWith("**")){
                line=line.replaceAll("[**]", "");
                System.out.println(line);
                while((line=s.nextLine())!=null){  
                    if(!(line.endsWith("**")))
                        System.out.println(line);
                    else if(line.endsWith("**")){
                           line=line.replaceAll("[**]","");
                        System.out.println(line);
                        break;
                    }

                }
            } 
        }
    } catch (Exception ex) {

        System.out.println(ex.getMessage());
    }