try{      

     BufferedWriter writer = new BufferedWriter(new FileWriter("filecsv.csv"));
           for(int index11 = 0; index11 < a.length; index11++) {
               for(int subIndex1 = 0; subIndex1 < 2; subIndex1++){
                   writer.write(String.valueOf(a[index11][subIndex1])); 
                   if(subIndex1<2-1){
                       writer.write(",");

                    }
               }
               writer.write("\n");
          }
}
    catch(IOException ex){
         ex.printStackTrace();
    }
        writer.close();