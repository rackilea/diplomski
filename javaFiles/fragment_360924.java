ArrayList<String> arr = new ArrayList<String>();

StringBuilder smsBuilder = new StringBuilder();
       final String SMS_URI_INBOX = "content://sms/inbox"; 
        final String SMS_URI_ALL = "content://sms/";  
        try {  
            Uri uri = Uri.parse(SMS_URI_INBOX);  
            String[] projection = new String[] { "_id", "address", "person", "body", "date", "type" };  
            Cursor cur = getContentResolver().query(uri, projection, "address=123456789", null, "date desc");
             if (cur.moveToFirst()) {  
                int index_Address = cur.getColumnIndex("address");  
                int index_Person = cur.getColumnIndex("person");  
                int index_Body = cur.getColumnIndex("body");  
                int index_Date = cur.getColumnIndex("date");  
                int index_Type = cur.getColumnIndex("type");         
                do {  
                    String strAddress = cur.getString(index_Address);  
                    int intPerson = cur.getInt(index_Person);  
                    String strbody = cur.getString(index_Body);  
                    long longDate = cur.getLong(index_Date);  
                    int int_Type = cur.getInt(index_Type);  

                    smsBuilder.append("[ ");  
                    smsBuilder.append(strAddress + ", ");  
                    smsBuilder.append(intPerson + ", ");  
                    smsBuilder.append(strbody + ", ");  
                    smsBuilder.append(longDate + ", ");  
                    smsBuilder.append(int_Type);  
                    smsBuilder.append(" ]\n\n"); 

arr.add(smsBuilder.toString());
                } while (cur.moveToNext());  

                if (!cur.isClosed()) {  
                    cur.close();  
                    cur = null;  
                }  
            } else {  
                smsBuilder.append("no result!");  
            } // end if  
            }
        } catch (SQLiteException ex) {  
            Log.d("SQLiteException", ex.getMessage());  
        }