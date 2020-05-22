String[][] array = .. //parsed xml

for(String[] row : array){
      createCell();  
      for(String cell : row){
         createRow();
      }
}