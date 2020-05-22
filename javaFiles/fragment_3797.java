class BasicDataPage extends JPanel{
    //constructors and initializations not shown..

    public void setPrentComponent(){
        Object o = getParent();
        MainClass mc;
        if(o != null && o instanceof MainClass)
            mc = (MainClass)o;

        mc.setTitle(lbl.getText());            
    }   
}