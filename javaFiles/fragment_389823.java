String filePath = "C:\\Users\\xyz\\Desktop\\";
    String originalFileName = "ConvertedJPGPDF.pdf";
    String newFileName = "test.pdf";

    byte[] input_file = Files.readAllBytes(Paths.get(filePath+originalFileName));

    byte[] decodedBytes1 = Base64.getMimeDecoder().decode(input_file);

    Files.write(Paths.get(filePath+newFileName), decodedBytes1);