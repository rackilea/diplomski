public static void skipLine(BufferedReader br) throws IOException {
    while(true) {
        int c = br.read();
        if(c == -1 || c == '\n')
            return;
        if(c == '\r') {
            br.mark(1);
            c = br.read();
            if(c != '\n')
                br.reset();
            return;
        }
    }
}