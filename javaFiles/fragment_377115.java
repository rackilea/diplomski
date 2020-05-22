try {
        accountfile = new File("./Clients/" + lastname + "/" + name + "/" + "BalanceInfo " + accountid + ".ACC");
    if(!accountfile.exists()) {
        accountfile.getParentFile().mkdirs();
        accountfile.createNewFile();
    }