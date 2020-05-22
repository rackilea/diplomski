JavaRDD<Model> fileRDD = sc.textFile("filePath")
            .filter(line -> {
                try {
                    String[] parts = line.split("\\|");
                    Long key = Long.parseLong(parts[0];
                    return true;
                } catch (NumberFormatException nfe) {
                    return false;
                }
            });