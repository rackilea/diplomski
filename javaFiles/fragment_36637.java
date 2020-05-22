result = "";
        len = 0;
        while ((len = zipIn.read(buffer)) > 0) {
            // System.out.print(new String(buffer));
            System.gc();
            result += result + new String(buffer);
        }