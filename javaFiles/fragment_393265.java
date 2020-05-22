hatNumber = in.readInt("How many beaver hats would you like?: \n");
    if (hatNumber > 0 && hatNumber <= 100) {
        System.out.println("Hats = " + hatNumber);
    } else {
        hatNumber = 0;
    }
    photoNumber = in.readInt("How many photographs would you like?: \n");
    if (photoNumber > 0 && photoNumber <= 100) {
        System.out.println("Photographs = " + photoNumber);
    } else {
        photoNumber = 0;
        jarNumber = in.readInt("How many Jars of maple syrup?: \n");
        if (jarNumber > 0 && jarNumber <= 100) {
            System.out.println("Jars = " + jarNumber);
        } else {
            jarNumber = 0;
        }
    }
    System.out.println("Hats = " + hatNumber);
    System.out.println("Photographs = " + photoNumber);
    System.out.println("Jars = " + jarNumber);