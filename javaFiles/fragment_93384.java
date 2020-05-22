FileInputStream fis = new FileInputStream(mfile); 
            FileChannel fc = fis.getChannel(); // Get the file's size and then map it into memory
            int sz = (int)fc.size();
            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, sz);
            byte[] data2 = new byte[bb.remaining()];
            bb.get(data2);
            ByteArrayEntityHC4 reqEntity = new ByteArrayEntityHC4(data2);
            httpPost.setEntity(reqEntity);
            fis.close();