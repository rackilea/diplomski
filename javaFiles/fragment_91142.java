if (file.exists()) {
            boolean bval = file.setExecutable(true);
            ..... set the owner's execute permission
        } else {
            ...... File does not exist;
        }


 if (file.exists()) {
            boolean bval = file.setExecutable(true, false);
            ..... set everybody's execute permission
        } else {
            ...... File does not exist;
        }