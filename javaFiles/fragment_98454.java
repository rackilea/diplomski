private static byte[] GetKey(byte[] suggestedKey)
      {
          byte[] kRaw = suggestedKey;
          ArrayList<Byte> kList = new  ArrayList<Byte>();

          for (int i = 0; i < 128; i += 8)
          {
              kList.add(kRaw[(i / 8) % kRaw.length]);
          }

          byte[] byteArray = new byte[kList.size()];
          for(int i = 0; i<kList.size(); i++){
            byteArray[i] = kList.get(i);
          }
          return byteArray;
      }