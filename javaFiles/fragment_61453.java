ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); 

    try{

            Scanner sc = new Scanner(new File("a.txt"));               
            while(sc.hasNextLine()){
            String line= sc.nextLine();             
            ArrayList<Integer> vertex = new ArrayList<Integer>();               
            Scanner lineContents = new Scanner(line).useDelimiter("\\D"); //"\\D" means any none digit

            while (lineContents.hasNext()) {
                    vertex.add(lineContents.nextInt());
            }

            graph.add(vertex);
            lineContents.close();
        }
        sc.close();
    }