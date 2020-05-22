public String[] create(){
    String[] arrayOX = new String[3][3];

    int k=1;
    for(int i=0;i<arrayOX.length;i++){
        for(int j=0;j<arrayOX.length;j++){
            arrayOX[i][j]=Integer.toString(k++);
        }
    }

    return arrayOX;
}