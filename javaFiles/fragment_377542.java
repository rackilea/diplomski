Base64.Encoder enc = Base64.getEncoder();
            byte[] encbytes = enc.encode(file.getBytes());
            for (int i = 0; i < encbytes.length; i++)
            {
                System.out.printf("%c", (char) encbytes[i]);
                if (i != 0 && i % 4 == 0)
                    System.out.print(' ');
            }
            Base64.Decoder dec = Base64.getDecoder();
            byte[] barray2 = dec.decode(encbytes);
            InputStream fis = new ByteArrayInputStream(barray2);

            PutObjectResult objectResult = s3client.putObject("xxx", 
            file.getOriginalFilename(), fis, data);