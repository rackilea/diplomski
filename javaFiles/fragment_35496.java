json_string=responseOutput.toString();
JSONArray jsonArray = new JSONArray(json_string);
                int count =0;
                count= jsonArray.length();
                JSONObject jobj = jsonArray.getJSONObject(0);
                String LabLocation = jobj.getString("LabLocation");
                String RackLocation = jobj.getString("RackLocation");
                String ShelfLocation = jobj.getString("ShelfLocation");
                String fourBid = jobj.getString("fourBid");
                String Cluster = jobj.getString("Cluster");
                String fourBookingName = jobj.getString("fourBookingName");
                String SoftwareVersion = jobj.getString("SoftwareVersion");
                String HardwareType = jobj.getString("HardwareType");
                String AssetNo = jobj.getString("AssetNo");
                String SerialNO = jobj.getString("SerialNO");
                String Location = jobj.getString("Location");

                return " "+"LabLocation" + ":" +"  " +LabLocation + "\n" + " "+"RackLocation" + ":" +"  "  +RackLocation
                        + "\n" + " "+"ShelfLocation" + ":" +"  "  +ShelfLocation + "\n" + " "+"4BookingID" + ":" +"  "  +fourBid
                        + "\n" + " "+"Cluster" + ":" +"  "  +Cluster + "\n" + " "+"4BookingName" + ":" +"  "  +fourBookingName
                        + "\n" + " "+"SoftwareVersion" + ":" +"  "  +SoftwareVersion + "\n" + " "+"HardwareType" + ":" +"  "  +HardwareType
                        + "\n" + " "+"AssetNo" + ":" +"  "  +AssetNo + "\n" + " "+"SerialNO" + ":" +"  "  +SerialNO + "\n" + " "+"Location" + ":" +"  "  +Location;
            }