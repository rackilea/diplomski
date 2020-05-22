FUNCTION Decryptraw (datas         VARCHAR2, 
                       c_encrypt_key VARCHAR2) 
  RETURN VARCHAR2 
  IS 
    l_enc_val      RAW (8000); 
    v_receivedsalt RAW(8000); 
    v_receivedmac  RAW(8000); 
    mac            RAW(8000); 
    macsource      RAW(8000);
    mackey         RAW(8000);
    rawtohash      RAW(8000); 
    l_enc_algo     PLS_INTEGER; 
    l_in           RAW (8000); 
    l_iv           RAW (8000); 
    l_ret          VARCHAR2 (8000); 
    daten          RAW(8000); 
  BEGIN 
      daten := utl_encode.Base64_decode(utl_raw.Cast_to_raw(datas));  
      macSource := utl_raw.cast_to_raw('mac');

      --Parse the received string for data required for decryption   
      --String    | IV | Salt | MAC | EncryptedData   
      --Bytes       8     24    20     The rest   
      --HexChars    16    48    40     The rest    
      l_iv := Substr(daten, 1, 16); 
      v_receivedsalt := Substr(daten, 17, 48);
      v_receivedmac := Substr(daten, 65, 40); 
      l_in := Substr(daten, 105); 

      --Concatenate the key (password) and salt so that they can be   
      --hashed together   
      rawtohash := Concat(utl_raw.Cast_to_raw(c_encrypt_key), v_receivedsalt); 


      --Hash the key+salt string using SHA1   
      --A stronger algorithm is preferred but not currently available in   
      --oracle SQL   
      rawtohash := dbms_crypto.Hash(rawtohash, dbms_crypto.hash_sh1); 
      macKey := rawtohash;
      rawtohash := utl_raw.Concat(rawtohash, v_receivedsalt); 
      rawtohash := utl_raw.Substr(rawtohash, 1, 24); 

      --Hash the MAC source using hmac_sh1, with the    
      --password + receivedsalt as the key   
      mac := dbms_crypto.Mac(src => macsource, KEY => macKey, typ => 
             dbms_crypto.hmac_sh1);

      --In the case that the MAC generated in this function   
      --does not match the MAC parsed from the received data,   
      --something has gone wrong during the data sending process.   
      --The data will not be decrypted or parsed, because it has   
      --most likely been tampered with or corrupted.   
            IF ( mac != v_receivedmac ) THEN   
              Raise_application_error(-20101,   
              'Recieved MAC or Salt don''t match the generated MAC.'   
              );   
            END IF;     

      --Decrypt the data using the hashed password+salt as the key    
      l_enc_val := dbms_crypto.Decrypt (src => l_in, KEY => rawtohash, iv => 
                   l_iv, 
                   typ 
                   => 
                                dbms_crypto.des3_cbc_pkcs5); 

      RETURN utl_raw.Cast_to_varchar2(l_enc_val); 
  END decryptraw;