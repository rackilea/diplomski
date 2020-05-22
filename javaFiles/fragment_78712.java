String line;
        while ((line = r.readLine()) != null) {
            int ind = line.indexOf("package: name=");
            if (ind >= 0) {
                String yourValue = line.substring(ind + "default =".length(), line.length() - 1).trim(); // -1 to remove de ";"
                System.out.println(yourValue);
          }