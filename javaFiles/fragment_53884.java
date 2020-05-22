public class ScanListener extends SDScanAdapter {
    @Override
    public void scanComplete(String contactName, String action) {
        runOnUiThread(scanComplete);
    }

    @Override
    public void startScan() {
        runOnUiThread(startScan);
    }

    @Override
    public void updateScanProgress(int scanItemsTotal,
            int scanItemsCompleted) {
        if (scanCountTotal != scanItemsTotal) {
            scanCountTotal = scanItemsTotal;
            progressBar.setMax(scanCountTotal);
        }
        if (scanCountUpdate != scanItemsCompleted) {
            scanCountUpdate = scanItemsCompleted;
            runOnUiThread(updateScanProgress);
        }
    }
}