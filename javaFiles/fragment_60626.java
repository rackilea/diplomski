File dir = new File(Environment.getExternalStorageDirectory());
    int num=0;
    String[] children = dir.list();
    if (children == null) {
        // Either dir does not exist or is not a directory
    } else {
        for (int i=0; i<children.length; i++) {
            // Get filename of file or directory
            String filename = children[i];
          if(filename.startsWith("thisfile")
              num++;
        }
    }

System.out.println("total number "+num);