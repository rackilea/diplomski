Scanner input;
        String tokenizer[]; 
        try {
            input = new Scanner(new File("D:\\textfile.txt"));
            input.useDelimiter("\\n");
                while(input.hasNextLine()) {
                    tokenizer = input.next().split(":"); 
                     System.out.println(tokenizer[0]+"   |"+tokenizer[1]+" | "+tokenizer[2]);

                    }


        }catch(Exception e){}