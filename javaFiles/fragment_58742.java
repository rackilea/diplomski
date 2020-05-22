import com.sun.swing.internal.plaf.basic.resources.basic;

    String cancel = "OptionPane.cancelButtonText";
    ListResourceBundle bundle = new basic();
    for (String key : bundle.keySet()) {
        if(cancel.equals(key)) {
            System.out.println(key
                    + ": " + bundle.getString(key));

        }
    }