final public static ImageProperties getJpegProperties(File file) throws FileNotFoundException, IOException {
    BufferedInputStream in = null;
    try {
        in = new BufferedInputStream(new FileInputStream(file));

        // check for "magic" header
        byte[] buf = new byte[2];
        int count = in.read(buf, 0, 2);
        if (count < 2) {
            throw new RuntimeException("Not a valid Jpeg file!");
        }
        if ((buf[0]) != (byte) 0xFF || (buf[1]) != (byte) 0xD8) {
            throw new RuntimeException("Not a valid Jpeg file!");
        }

        int width = 0;
        int height = 0;
        char[] comment = null;

        boolean hasDims = false;
        boolean hasComment = false;
        int ch = 0;
        int totalHeaderLen = 0;

        while (ch != 0xDA && !(hasDims && hasComment)) {
            /* Find next marker (JPEG markers begin with 0xFF) */
            while (ch != 0xFF) {
                ch = in.read();
            }
            /* JPEG markers can be padded with unlimited 0xFF's */
            while (ch == 0xFF) {
                ch = in.read();
            }
            /* Now, ch contains the value of the marker. */

            int length = 256 * in.read();
            length += in.read();

            totalHeaderLen += length;

            if (length < 2) {
                throw new RuntimeException("Not a valid Jpeg file!");
            }
            /* Now, length contains the length of the marker. */

            if (ch >= 0xC0 && ch <= 0xC3) {
                in.read();
                height = 256 * in.read();
                height += in.read();
                width = 256 * in.read();
                width += in.read();
                for (int foo = 0; foo < length - 2 - 5; foo++) {
                    in.read();
                }
                hasDims = true;
            } else if (ch == 0xFE) {
                // that's the comment marker
                comment = new char[length - 2];
                for (int foo = 0; foo < length - 2; foo++)
                    comment[foo] = (char) in.read();
                hasComment = true;
            } else {
                // just skip marker
                for (int foo = 0; foo < length - 2; foo++) {
                    in.read();
                }
            }
        }

        if(comment == null) comment = "no comment".toCharArray();

        return (new ImageProperties(width, height, new String(comment), totalHeaderLen, "jpeg"));

    } finally {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
            }
        }
    }
}