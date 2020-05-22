deleteAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    File directory = new File (externalStoragePath + File.separator + "Android/data/com.whizzappseasyvoicenotepad/");
                    File deleteFile = new File (directory, fileNames.get(toDelete) + ".mp3");
                    deleteFile.delete();
                    Log.i("TAG", "Deleting file: " + directory + fileNames.get(toDelete) + ".mp3");

                    listAdapter.remove(listAdapter.getItem(toDelete));
                    listAdapter.notifyDataSetChanged();

                    dialog.dismiss();
                }
            });