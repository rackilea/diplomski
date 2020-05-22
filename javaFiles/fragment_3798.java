class TestRunner{
    public static void main(String[] args){
        MainClass mc = new MainClass();   //I will rename this class if I were you
        BasicDataPage bdp = new BasicDataPage();
        mc.add(bdp);                      //add panel to frame;
        bdp.setParentComponent();         //Set parent container
    }
}