findUpdate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boolean foundUsb = false;
            usbManager = (UsbManager) getSystemService(Context.USB_SERVICE);
            deviceList = usbManager.getDeviceList();
            deviceIterator = deviceList.values().iterator();
            while(deviceIterator.hasNext()){

                UsbDevice device = deviceIterator.next();
                Log.d("UPDATER", "Device Attached: " + device.getManufacturerName());

                if (!Objects.equals(device.getManufacturerName(), gv.getManufacturerIDPlaca())) {
                    foundUsb = true;
                    PendingIntent mPermissionIntent = PendingIntent.getBroadcast(SetupActivity.this, 0, new Intent(ACTION_USB_PERMISSION), 0);

                    if (!usbManager.hasPermission(device)) {
                        usbManager.requestPermission(device, mPermissionIntent);
                        IntentFilter filter = new IntentFilter(ACTION_USB_PERMISSION);
                    }

                    try {
                        File file = new File("/storage/usbhost/update-binary.apk");
                        if (file.exists()) {
                            Intent newIntent = new Intent(Intent.ACTION_VIEW);
                            newIntent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                            newIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(newIntent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), R.string.UPDATE_APK_NO_ENCONTRADA, Toast.LENGTH_LONG).show();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            if (!foundUsb) {
                Toast.makeText(context, R.string.USB_NO_CONECTADO, Toast.LENGTH_SHORT).show();
            }
        }
    });