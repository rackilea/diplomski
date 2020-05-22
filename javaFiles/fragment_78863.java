for (Fid fid : Fid.values()) {
    System.out.println(fid.getId());
    // not read 03f00 and 0500 not files
    if(!fid.getId().equals("3f,00") && !fid.getId().equals("05,00")){
        b = readCard(r, channel, fid.getId());
        // header block file
        byte[] htba = OperationHelper.hexToByteAr(fid.getId());
        byte[] sizeByte = ByteBuffer.allocate(4).putInt(b.length).array();
        headerBlock[0] = htba[0];       // id file byte 1
        headerBlock[1] = htba[1];       // id file byte 2
        headerBlock[2] = 0;             // type file data
        headerBlock[3] = sizeByte[2];   // size file byte 1
        headerBlock[4] = sizeByte[3];   // size file byte 2
        try{
            fileTGD.write(headerBlock);
            fileTGD.write(b);
            // add signature file
            if (!fid.getId().equals("00,02") && !fid.getId().equals("00,05")
                    && !fid.getId().equals("C1,00") && !fid.getId().equals("C1,08")
                    && !fid.getId().equals("05,0E")){
                performHashFile(r, channel);
                b = signature(r, channel);
                sizeByte = ByteBuffer.allocate(4).putInt(b.length).array();
                headerBlock[0] = htba[0];
                headerBlock[1] = htba[1];
                headerBlock[2] = 1;
                headerBlock[3] = sizeByte[2];
                headerBlock[4] = sizeByte[3];
                fileTGD.write(headerBlock);
                fileTGD.write(b);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}