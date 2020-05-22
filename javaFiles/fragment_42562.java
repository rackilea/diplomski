IndexColorModel colorModel = new IndexColorModel(2,         // bits per pixel
                                                 4,         // size of color component array
                                                 palette,   // color map
                                                 0,         // offset in the map
                                                 true,      // has alpha
                                                 3,         // the pixel value that should be transparent
                                                 DataBuffer.TYPE_BYTE);