byte[] imageSrc= [...];
        // That's where the RGBA array goes.
        byte[] imageRGBA = new byte[imageSrc.length * 4];
        int i;
        for (i = 0; i < imageSrc.length; i++) {
            imageRGBA[i * 4] = imageRGBA[i * 4 + 1] = imageRGBA[i * 4 + 2] = ((byte) ~imageSrc[i]);

            // Invert the source bits
            imageRGBA[i * 4 + 3] = -1;// 0xff, that's the alpha.
        }

        // Now put these nice RGBA pixels into a Bitmap object
        Bitmap bm = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        bm.copyPixelsFromBuffer(ByteBuffer.wrap(imageRGBA));