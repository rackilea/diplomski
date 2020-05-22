try {
            String root_sd = Environment.getExternalStorageDirectory().toString();
            String theFile = root_sd + "/" + (String) getListAdapter().getItem(row);
            File file = new File(theFile);
            FileInputStream source= new FileInputStream(file);
            String targetDirectory = Environment.getExternalStorageDirectory().toString();
            FileOutputStream destination = new FileOutputStream(targetDirectory + "/videos/" + file.getName);
            FileChannel sourceFileChannel = source.getChannel();
            FileChannel destinationFileChannel = destination.getChannel();
            long size = sourceFileChannel.size();

            sourceFileChannel.transferTo(0, size, destinationFileChannel);


        } catch (Exception ex) {
            Logger.getLogger(Borrar.class.getName()).log(Level.SEVERE, null, ex);
        }