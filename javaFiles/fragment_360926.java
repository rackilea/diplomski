File folder = new File(Environment.getExternalStorageDirectory() + "/CustomFolder");
        File file;
        if (!folder.exists()) {
            boolean success = folder.mkdir();
            if (success){
                file = new File(folder.getPath() + "/" + UUID.randomUUID(), toString()+ ".jpg");
            }else {
                //Some message
            }
        }else {
            file = new File(folder.getPath() + "/" + UUID.randomUUID(), toString()+ ".jpg");
        }
//The rest of your code...