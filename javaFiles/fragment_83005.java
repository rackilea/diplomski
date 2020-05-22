CSVWriter writer = new CSVWriter(new FileWriter("C:\\Users\\map.csv")) ;
            for(String keys:tree_map.keySet()){
                String[] y=new String[2];
                y[0]=keys;
                y[1]=tree_map.get(keys).toString();
                writer.writeNext(y);
            }