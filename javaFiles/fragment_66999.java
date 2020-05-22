@Override
protected void init(){
    super.init();
    mountPage("/index.html", StandardPage.class);
    mountPage("/another.html", StandardPage2.class);
}