class MyBean{
    Injection1 ijn1;
    Injection2 ijn2;
    MyBean(Injection1 ijn1){
      this.ijn1=ijn1;
    }

    public void setIjn2(Injection2 ijn2I ) {
      this.ijn2 = ijn2;
    }
}