String sample = "<DocumentImagePath>95230-88\\M0010002F.tif\\test</DocumentImagePath>\r\n" +
                "95230-88\\M0010002F.tif\\test\r\n" +
                "<DocumentImagePath>123-88\\M0010002F.tif\\test</DocumentImagePath>\r\n" +
                "<DocumentImagePath>abc-88\\M0010002F.tif\\test</DocumentImagePath>\r\n";

String result = Pattern.compile("<DocumentImagePath>.*?</DocumentImagePath>")
                       .matcher(sample)
                       .replaceAll(r -> r.group().replace('\\', '/'));

System.out.println(result);