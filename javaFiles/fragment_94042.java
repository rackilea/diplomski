boolean[] bad = new boolean[256];
 bad[13] = bad[10] = bad[2] = true; // add more 'bad' values here; assuming < 256
 BufferedReader br = new BufferedReader(reader);
 BufferedWriter bw = new BufferedWriter(writer);
 char[] block = new char[1024*4]; // read in 4k at a time
 for (int len; (len = br.read(block, 0, block.length())) > 0;) {
     for (int i=0; i<len; i++) {
         if (block[i] < 256 && bad[(int)block[i]]) block[i] = '\n';
     }
     bw.write(block, 0, len);
 }