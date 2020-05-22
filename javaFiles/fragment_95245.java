public class Action implements ActionListener{
    private GetSet get = new GetSet();  // **** added

    @Override
    public void actionPerformed(ActionEvent e) {

        // GetSet get = new GetSet();
        if(e.getSource().equals(saveProject)){
            try {
                CreateProject op = new CreateProject();
                loadProjectUrl = op.setProjectUrl();                    
                get.setLoadProjectUrl((String)loadProjectUrl);

                // ....
                }
            } catch (IOException ex) {
                Logger.getLogger(DoubleViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        };

        if(e.getSource().equals(ruler)){
            System.out.println("ruler button clicked");
            String a = get.getLoadProjectUrl();
            System.out.println(a);
        };
    }
}