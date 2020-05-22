public String SearchInstallationBySerialNumber(String serial) {

    String installation = null;
    for (int i = 0; i < _allItems.size(); i++) {

        OsbDownloadItem currentOsbItem = _allItems.get(i);
        if (currentOsbItem.getSerialNumber().equals(serial)) {

            installation = currentOsbItem.getInstallation();
            break;
        }

    }
    if (installation == null) {
        Toast.makeText(mActivity, "unsuccessful searching", Toast.LENGTH_SHORT).show();
    }
    return installation;
}