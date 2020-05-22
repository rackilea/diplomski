Bar bar = new Bar(tChart1.getChart());
bar.fillSampleValues();
bar.setColorEach(true);

tChart1.doInvalidate();
Image img = tChart1.getExport().getImage().image(400, 200);
MediaStore.Images.Media.insertImage(getContentResolver(), img.bitmap, "test.jpg", "test.jpg");