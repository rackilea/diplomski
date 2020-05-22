for(int ofs=0,number_read; (number_read=sox_read(in,samples,MAX_SAMPLES))!=0; ofs+=number_read) {
    sox_write(out,samples,number_read);
    if(ofs>=16,384 && ofs<32000) {                          // from 16384
        memcpy(jvatgt,buffer,min(number_read,(32000-ofs)); // to 32000 (see question)
        }
    //(*Env) -> CallStaticVoidMethod (env, cls, mid, buffer_size); WTH??
    }