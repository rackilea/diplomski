String str = null;

    if(str.equals("test")) {  // NullPointerException
        System.out.println("After");
    }
    if("test".equals(str)) {  // No Exception will be thrown. Will return false
        System.out.println("Before");
    }