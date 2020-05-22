FieldsMetadata metadata = new FieldsMetadata();
 metadata.addFieldAsImage("chart1");
 metadata.addFieldAsImage("chart2");
 report.setFieldsMetadata(metadata);

 IImageProvider logo = new FileImageProvider(new File("path/to/image1"), true);
 context.put("chart1", logo);

 IImageProvider logo2 = new FileImageProvider(new File("path/to/image2"), true);
 context.put("chart2", logo2);