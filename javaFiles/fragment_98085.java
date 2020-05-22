DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Matches").child("Match_01");
Map<String, Object> updates = new HashMap<String,Object>();

updates.put("matchID", newID);
updates.put("homeScore", newscore);
//etc

ref.updateChildren(updates);