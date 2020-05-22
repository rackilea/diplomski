while ((line = br.readLine()) != null){
            if (line.startsWith("group")&&line.contains(",")==false){  
                String[] title = line.split("= ");                
                groupTitle= title[1].split(" ");
          // System.out.println(Arrays.toString(groupTitle));

            }
               if (line.startsWith("group_sub")){
                     String[] names = line.split("= ");   
                     groupSubjects= names[1].split(", "); 
               //    System.out.println(Arrays.toString(groupSubjects));

                     if(groupTitle!=null&&groupSubjects!=null){
                      String[] both = new String[groupTitle.length + groupSubjects.length];
                       System.arraycopy(groupTitle, 0, both, 0, groupSubjects.length);
                      System.arraycopy(groupSubjects, 0, both, groupTitle.length, groupSubjects.length);
                      System.out.println(Arrays.toString(both));
                       }
                }


}