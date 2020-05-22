int ret = usbDeviceConnection.bulkTransfer(writeEndpoint, data, data.length, 5000;


     if(ret < 0)
                    {
                      Log.d("TAG", "Error happened!");
                    }
                    else if(ret == 0)
                    {
                        Log.d("TAG", "No data transferred!");
                    }
                    else
                    {
                        Log.d("TAG", "success!");
                    }