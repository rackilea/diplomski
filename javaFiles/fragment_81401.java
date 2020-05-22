if (cmd.getName().equalsIgnoreCase("spyblocks")) {

        if (Main.spyblock == true) {

            Main.spyblock = false;
        }
        else {
            Main.spyblock = true;
        }
        **return true;**
    }