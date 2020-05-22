public Test() {
    initComponents();
    JCheckBox x = new JCheckBox("ergcdf"); //create the component,
    x.setSize(100,30);                     //size the component 
    this.testPanel1.add(x);                //and then add it to the panel
    this.testPanel1.add(new JCheckBox("ergcdf1"));
    this.testPanel1.add(new JCheckBox("ergcdf2"));
    this.testPanel1.add(new JCheckBox("ergcdf3"));
    this.testPanel1.add(new JCheckBox("ergcdf4"));
    this.testPanel1.validate();
    this.validate();
}