File excelFile = new File(Environment.getExternalStorageDirectory(),"nameexcelFile.pdf");//File path
        if (excelFile.exists()) //Checking if the file exists or not
        {
            Uri path = Uri.fromFile(excelFile);
            Intent objIntent = new Intent(Intent.ACTION_VIEW);
            objIntent.setFlags(Intent. FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(objIntent);//Starting the excel file viewer
        } else {

            Toast.makeText(getActivity(), "The file not exists! ", Toast.LENGTH_SHORT).show();

        }