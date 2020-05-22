int ch = fEntityScanner.peekChar();
if (ch == -1) {
    setScannerState(SCANNER_STATE_TERMINATED);
    return XMLEvent.END_DOCUMENT ;
} else{
    reportFatalError("ContentIllegalInTrailingMisc",
            null);
    fEntityScanner.scanChar();
    setScannerState(SCANNER_STATE_TRAILING_MISC);
    return XMLEvent.CHARACTERS;
}