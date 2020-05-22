if (list[i].isDirectory()) {
            // System.out.println("Searching Path...");
            String result = findFile(list[i], target);
            if (!result.equals("File Not Found") && !result.equals("Path Doesnt Exist.")) {
                return result;
            }
        }