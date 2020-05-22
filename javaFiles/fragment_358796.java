private void btnFileSaveActionPerformed(java.awt.event.ActionEvent evt) 
{                                            
   try{
      BufferedWriter bfw = new BufferedWriter(new FileWriter("D:\\CedulaList.txt"));

              for (int i = 0 ; i < tableCedula.getRowCount(); i++)
              {

                for(int j = 0 ; j < tableCedula.getColumnCount();j++)
                {
                    bfw.newLine();
                    bfw.write((String)(tableCedula.getValueAt(i,j)));
                    bfw.write("\t");;
                }
              }
   }catch(Exception ex){

   }finally{
      if(bfw != null){
         bfw.close();
      }
   }    
}