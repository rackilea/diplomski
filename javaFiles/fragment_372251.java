private boolean Extract(String src, String dst, String incPath) {


    TFile srcFile = new TFile(src, incPath);
    TFile dstFile = new TFile(dst);
    try {
        TFile.cp_rp(srcFile, dstFile, TArchiveDetector.NULL);
    } catch (IOException e) {
       return true;
    }

    return true;
}