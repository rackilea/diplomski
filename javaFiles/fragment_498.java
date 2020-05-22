if(TextUtils.equals(action,BluetoothDevice.ACTION_ACL_DISCONNECTED)) {
   BluetoothDevice device = intent.getExtras()
                                   .getParcelable(BluetoothDevice.EXTRA_DEVICE);
   if (isYourDevice(device)) {
       // to push your notification
   }
}