BluetoothDevice btd = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

if(btd.getBluetoothClass().getDeviceClass() == BluetoothClass.Device.bla_bla_bla)
{
   //do whatever you want with the filtered device
}