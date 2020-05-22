while (ze != null) {
                String fileName = ze.getName();

                if (fileName.contains(":")){
                    fileName = fileName.replaceAll(":", "_");

                }