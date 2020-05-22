try(Scanner reader = new Scanner(file)){
        while(reader.hasNextLine()){
            String line = reader.nextLine();
            //split line into an array, delimited by spaces
            String[] lines = line.split(" ");
            //loop through the resulting array
            for (int i = 0 ; i < lines.length; i++){
                //print each number on a single line
                System.out.println(lines[i]);
            }
        }