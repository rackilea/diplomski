long size = 0;
        System.out.println(dir.toString());
        File[] tmp = dir.listFiles();
        if ( tmp != null ) {
            for (File file : dir.listFiles()) { // NPE gone
                if (file.isFile())
                    size += file.length();
                else
                    size += calcSize(file);
            }
        }