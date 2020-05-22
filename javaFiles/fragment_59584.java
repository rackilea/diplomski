JFrame1 form = new JFrame1();
form.setVisible(true);
form.addPropertyChangeListener(new PropertyChangeListener() {

    @Override
    public void propertyChange(PropertyChangeEvent pce) {
        // Handle the change here

        String pth = (String) pce.getNewValue();
        BufferedReader datafile = readDataFile(pth);

        Instances data = new Instances(datafile);
        data.setClassIndex(data.numAttributes() - 1);

        (...)
    }

});