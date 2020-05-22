public List<String> getFiles(String folder) {

List<String> list = new ArrayList<String>();
        File dir = new File(folder);
        if(dir.isDirectory()) {
            FileFilter filter = new FileFilter() {

                public boolean accept(File file) {
                    boolean flag = false;
                    if(file.isFile() && !file.isDirectory()) {
                        String filename = file.getName();
                        if(!filename.endsWith(".zip")) {
                            return true;
                        }
                        return false;   
                }

            };
            File[] fileNames = dir.listFiles(filter);
            for (File file : fileNames) {
                list.add(file.getName());
            }
            return list;