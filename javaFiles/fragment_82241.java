List<String> loglist = new ArrayList<String>(); // declare your list outside the listener, or make it as class variable.   
            LocationManager logManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
                logManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30000, 100, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {

                        double latitude=location.getLatitude();
                        double longitude=location.getLongitude();
                        DecimalFormat dFormat = new DecimalFormat("#.####");
                        Date date=new Date();
                        SimpleDateFormat sdf=new SimpleDateFormat("kk:mm");
                        String time=sdf.format(date);

                        Toast.makeText(MainPage.this,loglist.toString(),Toast.LENGTH_LONG).show();
                        if (loglist.size()==6){// you reach 6 values => send the SMS
                            StringBuilder log = new StringBuilder();
                            for (int j=0;j<loglist.size();j++){
                                log.append(loglist.get(j).toString());
                            }

                           SmsManager smsManager=SmsManager.getDefault();
                            smsManager.sendTextMessage(logPreferences.getString("admin1",""),null,log.toString(),null,null);
                        } else {// you can add more location
                           loglist.add("!+" + dFormat.format(latitude) + ",+" + dFormat.format(longitude) + "," + time);
                        }
                    }