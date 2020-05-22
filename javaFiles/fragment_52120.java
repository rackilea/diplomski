public CMapEncoding(String cmap, String uniMap) {
    this.cmap = cmap;
    this.uniMap = uniMap;
    if (cmap.equals(PdfEncodings.IDENTITY_H) || cmap.equals(PdfEncodings.IDENTITY_V)) {
        cid2Uni = FontCache.getCid2UniCmap(uniMap);
        isDirect = true;
        this.codeSpaceRanges = IDENTITY_H_V_CODESPACE_RANGES;
    } else {
        cid2Code = FontCache.getCid2Byte(cmap);
        code2Cid = cid2Code.getReversMap();
        this.codeSpaceRanges = cid2Code.getCodeSpaceRanges();
    }
}