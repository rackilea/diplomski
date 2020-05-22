Process 27371 stopped
* thread #1: tid = 0x286a3, 0x000000010000ba99 openssl`dgst_main(argc=0, argv=0x00007fff5fbffa60) + 5961 at dgst.c:513, queue = 'com.apple.main-thread', stop reason = breakpoint 1.1
    frame #0: 0x000000010000ba99 openssl`dgst_main(argc=0, argv=0x00007fff5fbffa60) + 5961 at dgst.c:513
   512      
-> 513      if (argc == 0)
   514      {
   515          BIO_set_fp(in,stdin,BIO_NOCLOSE);
   516          err=do_fp(out, buf,inp,separator, out_bin, sigkey, sigbuf,
(lldb)