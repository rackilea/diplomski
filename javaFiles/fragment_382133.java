for (i = 0; i < File_1.length-1; i++)
{
   for(int j=0;j< File_2.length; j++)
   {
      if(File_1[i].ID != null && File_2[j].ID != null && File_1[i].Relation != null && File_2[j].Relation !=null)
      {
         if(File_1[i].ID.equals(File_2[j].ID) && File_1[i].Relation.equals(File_2[j].Relation))
         {
            if(!(File_1[i].Result.equals(File_2[j].Result)))
            {
               System.out.println(File_1[i].ID);
               System.out.println(File_1[i].Relation);
               System.out.println(File_1[i].Result);
               if(File_1[i].Comment != null)
                  System.out.println(File_1[i].Comment);
            }
         }
      }
   }
}