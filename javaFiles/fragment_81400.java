if (cmd.getName().equalsIgnoreCase("spyblocks")) {
        **return true;**
        if (Main.spyblock == true) {

            Main.spyblock = false;
        }
        else {
            Main.spyblock = true;
        }
    }