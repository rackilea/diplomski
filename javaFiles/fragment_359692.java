String matInsert = null;
 for (int k=0;k<di.mat.length;k++) {  //row
    String m="";
    String sep = "";
    for (int j=0;j<di.mat[k].length;j++) {
        m+= (sep+di.mat[k][j]);
        sep = " ,";
    }
    matInsert="INSERT INTO "+ tableName  +"("+ff+")"+"values" +"("+m+")";   
    System.out.println(matInsert);
    stmt1.executeUpdate(matInsert);
 }