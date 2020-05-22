try {

        Properties props;
        Property p=new Property();
        InputStreamReader  in=new InputStreamReader(p.getClass().getResourceAsStream("/config/" + "inputs.properties"));
        props = new Properties();

        props.load(in);

        JOptionPane.showMessageDialog(null, in.getClass());
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }