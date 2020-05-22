protected ScanResult.Status virusScanFile(File file) {
    ClamScan clamScan = new ClamScan(clamAVHost, clamAVPort, clamAVTimeout);
    ScanResult scanResult = null;
    if (clamScan.ping()) {
        try (InputStream inputStream = new FileInputStream(file)) {
            scanResult = clamScan.scan(inputStream);
        } catch (FileNotFoundException | IOException e) {
            logger.error(e.getStackTrace());
        } 
    } else {
        throw new RuntimeException("Could not scan file as ClamD did not respond to ping request!");
    }        
    ScanResult.Status scanResultStatus = null;
    if (scanResult != null) {
        scanResultStatus = scanResult.getStatus();
    }
    return scanResultStatus;
}