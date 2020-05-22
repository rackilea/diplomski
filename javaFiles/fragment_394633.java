File imgFile =
           new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Chrysanthemum.jpg");
        byte[] ba = Files.toByteArray(imgFile); //Its a google guava library
        int i = 0; 
        if((ba [i] & 0xFF) == 0xFF && (ba[i+1] & 0xFF) == 0xD8 && (ba[i+2] & 0xFF) == 0xFF 
           && (ba[i+3] & 0xFF) == 0xE0) {
           System.out.println("isJPEG");
        }