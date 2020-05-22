btnSaveTrip.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (showLog != null && showLog.getText().toString().length() > 0) {
            File folder = new File(Environment.getExternalStorageDirectory() + "/TollCulator");
            if (!folder.exists()) {
                folder.mkdir();
            }
            String externalStoragePath = Environment.getExternalStorageDirectory().toString();
            final File file = new File(externalStoragePath + "/TollCulator/strip.tcl");
            if (file.exists()) {
                new AlertDialog.Builder(getActivity())
                .setTitle("File Already Exist")
                .setMessage("Do you want to overwrite the existing file?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        writeFile(file);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
            } else {
                writeFile(file);
            }
        } else {
            Toast.makeText (getActivity(), "empty", Toast.LENGTH_SHORT).show();
        }
    }
});

// ...

private void writeFile(File file){
    try {
        outputStream = new FileOutputStream(file);
        outputStream.write(showLog.getText().toString().getBytes());
        Toast.makeText (getActivity(), file.toString(), Toast.LENGTH_SHORT).show();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if(outputStream!=null) {
            try {
                outputStream.close();
                Toast.makeText (getActivity(), "file closed", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText (getActivity(), "error in finally catch", Toast.LENGTH_SHORT).show();
            }
        }
    }
}