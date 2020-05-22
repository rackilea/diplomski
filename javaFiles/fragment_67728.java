private void storeScanValue(String scanResult) {
    count++;
    data.put(String.valueOf(count), scanResult);
    Log.e("Key_Value",""+count);
    Log.e("SIZE",""+data.size());
  }