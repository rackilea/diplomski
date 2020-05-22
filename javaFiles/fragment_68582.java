private void lllActionPerformed(java.awt.event.ActionEvent evt) {
    int n=Integer.parseInt(t1.getText());
    int r=Integer.parseInt(t2.getText());
    int s=1;
    for(int i=1;i<=n;i=i+1){
        s=i*s;
    }
    long p=1L;
    for(int j=1;j<=n-r;j=j+1){
        p=j*p;
    }
    long q=1L;
    for(int k=1;k<=r;k=k+1){
        q=k*q;
    }
    long re=s/(p*q);
    t3.setText(" "+re);
}