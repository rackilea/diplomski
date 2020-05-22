513      if (argc == 0)
   514      {
-> 515          BIO_set_fp(in,stdin,BIO_NOCLOSE);
   516          err=do_fp(out, buf,inp,separator, out_bin, sigkey, sigbuf,
   517                    siglen,NULL,NULL,"stdin",bmd);
   518      }
(lldb) p sigkey
(EVP_PKEY *) $25 = 0x0000000000000000