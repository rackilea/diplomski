case INS_INIT_CIPHER_ENC:
                myCipher.init(myRSAPubKey, Cipher.MODE_ENCRYPT);
                cipher_result_len = (short) 0x00;
                break;
case INS_ENC:
                apdu.setIncomingAndReceive();
                if (p1 == P1_CHAIN_APDU) {
                    cipher_result_len += myCipher.update(buff, dataOffset, lc, result, cipher_result_len); 
                } else if (p1 == P1_LAST_APDU) {
                    
                    try {
                        cipher_result_len += myCipher.doFinal(buff, dataOffset, lc, result, cipher_result_len);
                    } catch (CryptoException e) {
                        short reason = e.getReason();
                        ISOException.throwIt((short) ((short) 0x6B00 | reason));
                    }
                    apdu.setOutgoing();
                    apdu.setOutgoingLength(cipher_result_len);
                    apdu.sendBytesLong(result, (short) 0x00, cipher_result_len);
                }
                break;