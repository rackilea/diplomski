for (scanResult in results) {
    if (!scanResult.SSID.contains("_") {
        arrayList.add(scanResult.SSID)
        adapter!!.notifyDataSetChanged()
    }
}