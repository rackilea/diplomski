for (BluetoothDevice device: pairedDevice) {
     String name = device.getName();
     String address = device.getAddress();
     String toBeAdded = address + " " + name;
     if (!QueryDevices_final.contains(toBeAdded) {
             QueryDevices_final.add(toBeAdded);
             arrayAdapter.notifyDataSetChanged();
         }
     }