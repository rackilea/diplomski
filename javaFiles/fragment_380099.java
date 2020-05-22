$ openssl rsautl -verify -inkey private.pem -asn1parse < sign1
Error in encoding
139931349546656:error:0D07209B:asn1 encoding routines:ASN1_get_object:too long:asn1_lib.c:142:

$ openssl rsautl -verify -inkey private.pem -asn1parse < sign2
    0:d=0  hl=2 l=  49 cons: SEQUENCE          
    2:d=1  hl=2 l=  13 cons:  SEQUENCE          
    4:d=2  hl=2 l=   9 prim:   OBJECT            :sha256
   15:d=2  hl=2 l=   0 prim:   NULL              
   17:d=1  hl=2 l=  32 prim:  OCTET STRING      
      0000 - 26 3b 0a a1 2e b9 32 db-b8 dc d3 6f 37 94 0b 05   &;....2....o7...
      0010 - 71 9c ba 79 46 34 28 9f-5c 5b 98 9a 64 61 c9 ec   q..yF4(.\[..da..