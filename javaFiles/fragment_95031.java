// extract the next line from the stream
            tmp=scanner.nextLine().split("\t");

            do{
                // check if our number is in that line
                if (lista[i].equals(tmp[9])) {
                    while(scanner.hasNextLine()){
                        do{
                            tmp=scanner.nextLine();
                            if(tmp[0].equals("I")) {
                                System.out.println(Arrays.toString(tmp));
                            }
                        }while(tmp[0].equals("I"));
                    }
                }

            }while(scanner.hasNext() ) ;