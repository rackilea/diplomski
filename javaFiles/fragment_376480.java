String line = null;
       while((line = fin.nextLine()) != null){
            String[] tokens = line.split(" ");
            if (tokens.length > 1) {
                System.out.print(tokens[0]); // username
                System.out.print(tokens[1]); // password
            }
        }