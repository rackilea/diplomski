if(extn.equals(".jpg") || extn.equals(".gif")) 
      {   
        //give path to new file
        File file = new File(".//Downloaded"+str); 
        FileOutputStream fout = new FileOutputStream(file);

        //receive and save image from client 
        byte[] readData = new byte[1024]; 
        int offset =0; 
        while((i = dis.read(readData,0,readData.length-offset)) != -1){
              offset += i;
        }

            fout.write(readData, 0, readData.length); 
            if(flag==1) 
            { 
            ta.append("Image Has Been Downloaded"); 
            flag=0; 
            }  

    fout.flush(); 
    fout.close(); 

      } 
}