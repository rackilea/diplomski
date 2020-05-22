public class Testcheckbox {

        GridBagLayout gb = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();

        public Testcheckbox(){
        JFrame f=new JFrame();

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout(SwingConstants.NORTH_WEST));

        JPanel panel=new JPanel();
        panel.setLayout(gb);

        String label="hello";
        JLabel l1=new JLabel(label);
        l1.setHorizontalTextPosition(SwingConstants.LEFT);
        // gc.anchor=GridBagConstraints.NORTHWEST;
        gc.weightx = 0;
        gc.weighty = 0;
        gc.gridx = 1;
        gc.gridy = 0;
        panel.add(l1,gc);



        JCheckBox check=new JCheckBox();
        check.getAccessibleContext().setAccessibleDescription(label);
        check.setHorizontalTextPosition(SwingConstants.LEFT);
        // gc.anchor=GridBagConstraints.NORTH;
        gc.weightx = 0;
        gc.weighty = 0;
        gc.gridx = 0;
        gc.gridy = 0;
        panel.add(check,gc);

        f.add(content);
            content.add(panel);
        f.setSize(200, 300);
        f.setVisible(true);


    }
        public static void main(String[] args) {
            Testcheckbox t = new Testcheckbox();
        }
    }