if (nfcATag != null) {

            int x = 0;
            value = new ArrayList<>();

            while (x<MAXIMUN_SIZE_OF_NDEF_MESSAGE) {
      //chose better condition to break the while, but not in any way your actuall condition.
                byte[] command = new byte[]{0x30 , (byte) x};
                byte[] payload = nfcATag.transceive(command);



                int index = 0;
                for (byte b : payload) {
                    value.add(b);
                    index++;
                }
                x += 4;
                //TODO change this to check whether the first 8 elements in list are the same as equal to byte sequence
            }

        }