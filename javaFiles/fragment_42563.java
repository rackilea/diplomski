int[] palette = { 0x00ff00, 0xffff00, 0xff0000, 0xffff00 };
IndexColorModel colorModel = new IndexColorModel(2,
                                                 4,
                                                 palette,
                                                 0,
                                                 false,
                                                 3,
                                                 DataBuffer.TYPE_BYTE);