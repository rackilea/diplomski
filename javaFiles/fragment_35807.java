unsigned char intext[256], outtext[256];

memset(intext, 0x07, sizeof(intext)); //PKCS#5 padding (See documentation)
memset(outtext, 0, sizeof(outtext));
char *output = (char *)outtext;

DES_key_schedule keyschedc1;
DES_key_schedule keyschedc2;
DES_key_schedule keyschedc3;
DES_cblock keyc1;
DES_cblock keyc2;
DES_cblock keyc3;

DES_set_key((DES_cblock *)"abcdefgh", &keyschedc1);
DES_set_key((DES_cblock *)"ijklmnop", &keyschedc2);
DES_set_key((DES_cblock *)"qrstuvwx", &keyschedc3); 

strcpy((char *)intext, "holahola1");

for (int i=0; i<16; i += 8)
{
    DES_ecb3_encrypt((DES_cblock *)(intext + i),
                    (DES_cblock *)(outtext + i), 
                    &keyschedc1, &keyschedc2, 
                    &keyschedc3,DES_ENCRYPT);
}