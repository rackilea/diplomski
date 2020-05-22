// optimized if byte-aligned
if (N == 0) {
    try { 
        out.write(x); 
        out.flush();
    }
    catch (IOException e) { e.printStackTrace(); }
    return;
}