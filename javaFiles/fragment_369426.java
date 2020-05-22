public void encryptDecrypt(byte[] data, int length, byte[] key)
        {
            byte v3, v5, v6;
            int len = length;

            if(len > 0)
            {
                do
                {
                    --len;
                    v3 = (byte) (key[0] + 1);
                    key[0] = v3;
                    v5 = (byte) (key[4] + key[8 + v3]);
                    key[4] = v5;
                    v6 = key[8 + v3];
                    key[8 + v3] = key[8 + v5];
                    key[8 + key[4]] = v6;

                    data[length - len - 1] ^= key[8 + (byte)(key[8 + key[4]] + key[8 + key[0]])];
                }
                while(len > 0);
            }
        }