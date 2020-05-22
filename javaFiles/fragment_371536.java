HashMap<String, CallQueue> queues = new HashMap<String, CallQueue>(); 

while (query.next()) {
  if (!queues.isEmpty()) {
    if (queues.containsKey(query.getString("NAME"))) {
      CallQueue oldQueue = queues.get(query.getString("NAME"));
      double decimalTime = query.getDouble("DATE");
      int hourOfDay = (int)Math.round(24 * decimalTime);
      int callAmount = query.getInt("NoC");
      if (hourOfDay > 19) {
        hourOfDay = 19;
      }

      oldQueue.addCallsByTime(hourOfDay, callAmount);
    } else {
      String queueName = query.getString("NAME");
      if (!queueName.equalsIgnoreCase("PrivatOverflow")) {
        CallQueue cq = new CallQueue(query.getString("NAME"));
        double decimalTime = query.getDouble("DATE");
        int hourOfDay = (int)Math.round(24 * decimalTime); 
        int callAmount = query.getInt("NoC");
        if (hourOfDay > 19) {
          hourOfDay = 19;
        }
        cq.addCallsByTime(hourOfDay, callAmount);
        queues.put(query.getString("NAME"), cq);
      }
    }
  }
}

// you could return this if you just want a collection...
Collection<CallQueue> values = queues.values();

// Or this if you MUST have an ArrayList...
return new ArrayList(values);