streamReader = new InputStreamReader(incomingStream.getInputStream());
reader = new BufferedReader(streamReader);

while ((str1 = reader.readLine()).startsWith("GET")) {
            if (str1.contains("phone")
                    & str1.contains("LOCATION=false")) {
                String params = str1.substring(5);
                Log.d("substring", params);
                String paramStart = params.substring(1,
                        "phone".length() + 13);
                Log.d("substring-", paramStart);
                smsNumber = paramStart.split("=")[1];

            } else if (str1.contains("LOCATION=true")
                    & str1.contains("phone")) {

                String params = str1.substring(5);
                Log.d("substring", params);
                String paramStart = params.substring(1,
                        "phone".length() + 13);
                smsNumber = paramStart.split("=")[1];

                LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
                Criteria criteria = new Criteria();
                criteria.setAccuracy(Criteria.ACCURACY_FINE);
                criteria.setAltitudeRequired(true);
                criteria.setPowerRequirement(Criteria.POWER_MEDIUM);

                String provider = manager.getBestProvider(criteria, true);
                Location location = manager.getLastKnownLocation(provider);
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                CharSequence location_string = String.valueOf(latitude)
                        + "," + String.valueOf(longitude).toString();
                MESSAGE = MAP_LINk + location_string;

            } else if (str1.contains("IMAGE=true")) {

                try {

                    Camera mcamera = Camera.open();
                    mcamera.startPreview(); 
                    mcamera.takePicture(null, null, new PictureCallback() {

                        @Override
                        public void onPictureTaken(byte[] data,
                                Camera camera) {
                            // TODO Auto-generated method stub
                            File mpicture = getOutputMediaFile(MEDIA_TYPE_IMAGE);
                            if (mpicture == null) {
                                Log.d("*************",
                                        "NULL****************");
                                Log.v("test", "image not clicked");
                                writer.write("Picture could not be clicked:");
                                writer.flush();
                            }
                            try {

                                FileOutputStream outputfile = new FileOutputStream(
                                        "sdcard/DCIM/Camera/test.jpg");
                                outputfile.write(data);
                                outputfile.close();
                                MESSAGE = String.valueOf(data);
                                writer.write("Done-------------------");
                                writer.flush();
                                Log.v("test", "image clicked and saved in sdcard");
                            } catch (FileNotFoundException e) {
                                // TODO: handle exception
                                Log.d("EXCEPTION", "MESSAGE", e);
                            } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        }
                    });

                    mcamera.release();
                } catch (Exception e) {
                    // TODO: handle exception
                    Log.v("EXCEPTION", "The picture could not be taken.", e);
                }
            }
            if (!str1.contains("IMAGE=true")) {
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(smsNumber, null, MESSAGE, null,
                        null);
            }
            writer.write("MESSAGE SENT\nMESSGE-DETAILS\n" + MESSAGE+smsNumber);
            writer.flush();
        }

        writer.close();
        reader.close();
        Log.v("Sockets", "closed");
    }