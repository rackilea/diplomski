if(rs.next()){
    int MAX = rs.getInt(1);
    for(i=1; i <= Integer.parseInt(txtBarcode.getText()); i++){
        ...
        String strBarCodeImageSave = ""+(i+MAX)+".jpg";
        ...
    }
}