import java.awt.*;
    class GridBagLayout
    {
        public static void main(String[] args) {
            Frame f=new Frame();
            f.setSize(300,200);
            GridBagLayout gl = new GridBagLayout();
            f.setLayout(gl);
            GridBagConstraints g=new GridBagConstraints();
            g.gridx=0;
            g.gridy=0;
            f.add(new Label("Name") , g);

            g.gridy=1;
            f.add(new Label("Password") , g);

            g.gridx=1;
            g.gridy=0;
            f.add(new TextField(15) , g);

            g.gridy=1;
            g.gridx=1;
            f.add(new TextField(15) , g);       

            g.gridx=0;
            g.gridy=2;
            g.gridwidth=2;
            g.insets = new Insets(30,0,0,0);
            f.add(new Button("OK"),g);

            f.setVisible(true);
        }
    }