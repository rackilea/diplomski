for (NetworkInterface ni : Collections.list(eni)) {
        niclist[i]=ni.getName();
        if(niclist[i].matches("^wlan\\d{1,2}")){
            // Try dumping here
            System.out.println("NIC Name: "+niclist[i]);
            nic.addItem(niclist[i]);
            i++;
        }else{nicsa.setText("No Wireless Interface found..");
        }
    }