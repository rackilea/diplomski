public static ImageType getImageType(byte[] data) {
    if (data == null) {
        return UNKNOWN;
    }
    byte[] header = new byte[11];
    System.arraycopy(data, 0, header, 0, Math.min(data.length, header.length));
    int c1 = header[0] & 0xff;
    int c2 = header[1] & 0xff;
    int c3 = header[2] & 0xff;
    int c4 = header[3] & 0xff;
    int c5 = header[4] & 0xff;
    int c6 = header[5] & 0xff;
    int c7 = header[6] & 0xff;
    int c8 = header[7] & 0xff;
    int c9 = header[8] & 0xff;
    int c10 = header[9] & 0xff;
    int c11 = header[10] & 0xff;

    Log.d(TAG, "Headers: " + "\nc1: " + c1 + "\nc2: " + c2 + "\nc3: " + c3 + "\nc4: " + c4 +  "\nc5: " + c5
            + "\nc6: " + c6 + "\nc7: " + c7 + "\nc8: " + c8 + "\nc9: " + c9 + "\nc10: " + c10 + "\nc11: " + c11);

    // verify JPEG format
    if (c1 == 0xFF && c2 == 0xD8 && c3 == 0xFF) {
        if (c4 == 0xE0) {
            return JPEG;
        }

        /**
         * File format used by digital cameras to store images. Exif Format can be read by any application supporting JPEG. Exif Spec can be found at:
         * http://www.pima.net/standards/it10/PIMA15740/Exif_2-1.PDF
         */
        if ((c4 == 0xE1) && (c7 == 'E' && c8 == 'x' && c9 == 'i' && c10 == 'f' && c11 == 0)) {
            return JPEG;
        }
    }
    // verify JPEG2000 format. Codestream - http://sourceforge.net/p/optipng/mercurial/ci/a9d8ace0ee2f1aab641b787d252c166373bdeddc/tree/src/pngxtern/pngxrjpg.c#l26
    // 00 00 00 0C 6A 50 20 20 0D 0A 87 0A
    else if (c1 == 0x00 && c2 == 0x00 && c3 == 0x00 && c4 == 0x0C) {
        return JPEG2000;
    }

    // return JPEG by default
    return JPEG;
}