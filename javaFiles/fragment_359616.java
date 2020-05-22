for(int i=0;i<noOfCols1;i++)
        {
         for(int j=1;j<=noOfRows1;j++)
         {
          value1 = formatter.formatCellValue(sheet1.getRow(j).getCell(i));
           for(int m=1;m<=noOfRows2;m++)
           {
            value2 = formatter.formatCellValue(sheet2.getRow(m).getCell(i));
            value1= value1.trim();
            value2=value2.trim();
            int value2Position = sheet2.getRow(m).getCell(i).getRowIndex();
            if(!positions.contains(value2Position))
            {
             if(value1.contentEquals(value2))
             {
             positions.add(value2Position);
             matched = true;
             }
             else{
              matched = false;
             }
            }
            if(matched==true)
            {
             break;
            }
           }
           if(matched == false)
           {   
            int k=1;
                        
            if(cFilledPositions.isEmpty())
            {
             try{
             isEmpty = checkIfRowIsEmpty(sheet,k,formatter);
             if(isEmpty)
             {
              rowHead = sheet.createRow(k);
             }
                           rowHead.createCell(i).setCellValue(value1);
             }
             catch (Exception e){
              try{
               rowHead = sheet.createRow(k);
                rowHead.createCell(i).setCellValue(value1);
              }
              catch (Exception e1){
               
              }
             }
                
            }
            else
            {
             int l = cFilledPositions.size()-1;
              k = cFilledPositions.get(l)+1;
              try{
                     isEmpty = checkIfRowIsEmpty(sheet,k,formatter);
                     if(isEmpty)
                     {
                      rowHead =  sheet.createRow(k);
                     }
                    rowHead.createCell(i).setCellValue(value1);
              }
              catch (Exception e)
              {
               try{
                   rowHead = sheet.createRow(k);
                    rowHead.createCell(i).setCellValue(value1);
                  }
                  catch (Exception e1){
                   
                  }
              }
            }
            cFilledPositions.add(k); 
               }
           matched = false;
         }
         cFilledPositions.clear();
         positions.clear(); 
        }