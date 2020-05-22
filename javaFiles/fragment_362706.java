String id = "SELECT * FROM USERS WHERE Email_ID = '" + Email_ID + "'";
                Cursor c2 = db.rawQuery(id, null);
                if (c2.getCount() > 0) {
                    Toast.makeText(getApplicationContext(), "Email ID already exists", Toast.LENGTH_LONG).show();
                    return;
                }