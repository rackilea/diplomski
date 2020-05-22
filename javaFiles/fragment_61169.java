@Override
     public void onPageSelected(int position) {
          Message msg = UserFragment.handy.obtainMessage(); 
          Bundle b = new Bundle(); 
          b.putInt("m", 0); 
          b.putInt("p", position); 
          b.putStringArrayList("e", updateUserFrag(position));
          msg.setData(b); 
          UserFragment.handy.handleMessage(msg);                 
     }

   public ArrayList<String> updateUserFrag (int p) {           
         entryArray = new ArrayList<String>();
         StringBuilder sb = new StringBuilder();
         DBAdapter db = new DBAdapter(this);
         db.open();
         Cursor c = db.getAllEntries();
         try {
            while (c.moveToNext()) {
                if (c.getString(0).equals(users[p].getName())) {
                    sb.append(c.getString(1));
                    entryArray.add(sb.toString());
                }
            }
         } catch (Exception e) {}
         c.close();
         db.close();
        return entryArray;           
   }