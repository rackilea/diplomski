public static void lookupInsert(int invoiceNumber) throws IOException {
    Properties props = new Properties();
    File propertiesfile = new File("d:/rw/dump/Sequence.properties");
    if (propertiesfile.length() == 0) {
        try {
            propertiesfile.createNewFile();
            props.load(new FileInputStream(propertiesfile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int value = 1;
        props.setProperty(new Integer(invoiceNumber).toString(), new Integer(1).toString());
        try {
            props.store(new FileOutputStream(propertiesfile), null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ;
    }
    props.load(new FileInputStream(propertiesfile));
    System.out.println("props " + props.toString());

    //if there is no invoice number in properties file then get(invoiceNumber) will be null
    if (props.getProperty(String.valueOf(invoiceNumber)) == null) {
        props.setProperty(new Integer(invoiceNumber).toString(), new Integer(1).toString());
        try {
            props.store(new FileOutputStream(propertiesfile), null);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } else {
        System.out.println("inside else");
        int value = Integer.parseInt(props.getProperty(String.valueOf(invoiceNumber)).toString());
        value++;
        props.setProperty(new Integer(invoiceNumber).toString(), new Integer(value).toString());
        try {
            props.store(new FileOutputStream(propertiesfile), null);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}