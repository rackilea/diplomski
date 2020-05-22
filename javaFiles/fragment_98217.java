for (l=0;l<level2arraylist.size();l++)
{ 
     studenttomatch= level2arraylist.get(l);
     Iterator<SubjectnameandMark> itr=studenttomatch.iterator();  

     while(itr.hasNext())
     { 
         SubjectnameandMark st=(SubjectnameandMark)itr.next();  
         System.out.println(st.servterm+" "+st.servtermweight);  
     }
}