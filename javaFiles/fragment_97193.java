adapter.open();  // I was missing this line
            Cursor c = adapter.barcodeInfo(bNumber);
            c.moveToPosition(-1);
            while(c.moveToNext())
            {
                name = c.getString(c.getColumnIndex("barcode_item_name"));
                measurement = c.getInt(c.getColumnIndex("barcode_measurement"));
                unit = c.getString(c.getColumnIndex("barcode_unit"));

                Toast toast = Toast.makeText(this, "Adding" + name + "to Kitchen", Toast.LENGTH_SHORT);
                toast.show();
            }