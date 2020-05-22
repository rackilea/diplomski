public void actionPerformed (ActionEvent e){
    //...

    File save = new File("/home/bekk/Outline.txt");
    try {
        save(save, Clientname,
            DateofService,
            Nameofpc,
            manufacturer,
            CPUBit,
            Serialnumber,
            Productnumber,
            HardDriveplug,
            Typeofhd,
            ModelofHarddrive,
            SpeedofHardDrive,
            WhatDidtheCustomerSay,
            WorkDone,
            TechniciansComments,
            TechnicianWorking);
    } catch (IOException exp) {
        JOptionPane.showMessageDialog(null, "Failed to save file", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public void save(File save, String... values) throws IOException {
    PrintWriter out = null;
    try {
        out = new PrintWriter(save); 
        for (String value : values) {
            out.println(value);
        }
    } finally {
        try {
            out.close();
        } catch (Exception exp) {
        }
    }
}