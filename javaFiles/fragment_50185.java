int pos=0;
   List<Comparable> statusList = dataset.getRowKeys();
   for(Comparable status : statusList){

       if(status.equals("InProgress")){
           renderer.setSeriesPaint(pos,gp0);
       }
       else if (status.equals("Success")){
           renderer.setSeriesPaint(pos,gp1);
       }
       else if (status.equals("Failed")){
           renderer.setSeriesPaint(pos,gp2);
       }
       pos++;
   }