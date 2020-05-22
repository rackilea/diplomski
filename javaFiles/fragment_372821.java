private void SendBookingData(final String SendCustomerId,final String SendCustomerName, final String BookingDate,
            final String BookingTime, final String SendNetAmount,final String SendTotalAmount, final String SendTotalQuantity,
            final String SendDeliveryDate, final String GetBranchId,final String Senduserid,final String Sendratelistid) {

                    HttpClient client = new DefaultHttpClient();
                    JSONObject json = new JSONObject();
                    try {


                        String SendBookingURL= "your url";
                        HttpPost post = new HttpPost(SendBookingURL);       
                        HttpResponse response;
                        json.put("GetcustomerName", SendCustomerName);
                        json.put("GetBookingDate",BookingDate);
                        json.put("GetTotalCost", SendTotalAmount);
                        json.put("GetNetAmount", SendNetAmount);
                        json.put("GetTotalQuantity",SendTotalQuantity );
                        json.put("GetCustomerId", SendCustomerId);
                        json.put("GetDeliveryDate", SendDeliveryDate);
                        json.put("GetBookingtime", BookingTime);
                        json.put("GetBranchId", GetBranchId);
                        json.put("GetUserId", Senduserid);
                        json.put("GetRateListId", Sendratelistid);
                        StringEntity se = new StringEntity( json.toString()); 
                        se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                        post.setEntity(se);
                        try {
                            response = client.execute(post);
                            HttpEntity entity = response.getEntity();
                            if(entity != null) {
                                ResponseSummaryTable = EntityUtils.toString(entity);
                                System.out.println("body" + ResponseSummaryTable);
                            }
                        }
                          catch (Exception e) {
                                e.printStackTrace();
                            }
                       }
                            catch(Exception e){
                                e.printStackTrace();
                            }       
                       }