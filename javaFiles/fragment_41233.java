byte[] ba = new byte[1024*1024];
int off = 0;
int len = 0;
do {
    len = Integer.parseInt(br.readLine().split(";" , 2)[0],16);
    for (int cur = 0; cur < len;) {
        byte[] line0 = br.readLine().getBytes();
        for (int i = 0; i < line0.length; i++) {
            ba[off+cur+i] = line0[i];
        }
        cur += line0.length;
        if(cur < len) {
            ba[off+cur] = '\n';
            cur++;
        }
    }
    off += len;
} while(len > 0);