private void CopyReadAssets()
        {
            AssetManager assetManager = getActivity().getAssets();

            InputStream in = null;
            OutputStream out = null;
            String state = Environment.getExternalStorageState();
            if (!Environment.MEDIA_MOUNTED.equals(state)) {
                Toast.makeText(getActivity(), "External Storage is not Available", Toast.LENGTH_SHORT).show();
            }
            File pdfDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/PDFs");
            if (!pdfDir.exists()) {
                pdfDir.mkdir();
            }
            File file = new File(pdfDir + "/abc.pdf");

            try
            {
                in = assetManager.open("abc.pdf");
                out = new BufferedOutputStream(new FileOutputStream(file));
                copyFile(in, out);
                in.close();
                in = null;
                out.flush();
                out.close();
                out = null;
            } catch (Exception e)
            {
                Log.e("tag", e.getMessage());
            }
            if (file.exists()) //Checking for the file is exist or not
            {
                Uri path = Uri.fromFile(file);
                Intent objIntent = new Intent(Intent.ACTION_VIEW);
                objIntent.setDataAndType(path, "application/pdf");
                objIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Intent intent1 = Intent.createChooser(objIntent, "Open PDF with..");
                try {
                    startActivity(intent1);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getActivity(), "Activity Not Found Exception ", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getActivity(), "The file not exists! ", Toast.LENGTH_SHORT).show();
            }
        }