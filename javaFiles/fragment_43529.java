private void createPDF() {
    final File file = new File(uploadFolder, "AnswerSheet_" + queId + ".pdf");

    final ProgressDialog dialog = ProgressDialog.show(this, "", "Generating PDF...");
    dialog.show();
    new Thread(() -> {
        Bitmap bitmap;
        PdfDocument document = new PdfDocument();
           //  int height = 842;
             //int width = 595;
        int height = 1010;
        int width = 714;
        int reqH, reqW;
        reqW = width;

        for (int i = 0; i < array.size(); i++) {
               //  bitmap = BitmapFactory.decodeFile(array.get(i));
            bitmap = Utility.getCompressedBitmap(array.get(i), height, width);


            reqH = width * bitmap.getHeight() / bitmap.getWidth();
            Log.e("reqH", "=" + reqH);
            if (reqH < height) {
                  //  bitmap = Bitmap.createScaledBitmap(bitmap, reqW, reqH, true);
            } else {
                reqH = height;
                reqW = height * bitmap.getWidth() / bitmap.getHeight();
                Log.e("reqW", "=" + reqW);
                  //   bitmap = Bitmap.createScaledBitmap(bitmap, reqW, reqH, true);
            }
            // Compress image by decreasing quality
                // ByteArrayOutputStream out = new ByteArrayOutputStream();
               //  bitmap.compress(Bitmap.CompressFormat.WEBP, 50, out);
             //    bitmap = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray()));
            //bitmap = bitmap.copy(Bitmap.Config.RGB_565, false);
              //Create an A4 sized page 595 x 842 in Postscript points.
          //PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(595, 842, 1).create();
            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(reqW, reqH, 1).create();
            PdfDocument.Page page = document.startPage(pageInfo);
            Canvas canvas = page.getCanvas();

            Log.e("PDF", "pdf = " + bitmap.getWidth() + "x" + bitmap.getHeight());
            canvas.drawBitmap(bitmap, 0, 0, null);

            document.finishPage(page);
        }

        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            document.writeTo(fos);
            document.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        runOnUiThread(() -> {
            dismissDialog(dialog);

        });
    }).start();
}