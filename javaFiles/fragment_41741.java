ZipOutputStream zos = new ZipOutputStream(byteArrayOutputStream);

        int a = 0;
        for (String i : links){
            System.out.println("opening connection");
            URL url = new URL(i);
            InputStream in = url.openStream();

            ByteArrayOutputStream bao = writetopdf.manipulatePdf(in, data1 , data2, data3);

            byte[] ba = bao.toByteArray();
            ZipEntry entry = new ZipEntry("newform" + a +".pdf");
            entry.setSize(ba.length);
            zos.putNextEntry(entry);
            zos.write(ba);
            a++;
            in.close();
        }


        zos.close();

        System.out.println("File downloaded");
        return byteArrayOutputStream;