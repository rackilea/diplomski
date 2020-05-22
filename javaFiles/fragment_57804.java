for (int i = 1; i <=clientList.size() ; i++) {
        ...

     if (!clientsByYear.containsKey(year)) {
            HashMap<Integer, Integer> clientByMonth = new HashMap<>();
            clientByMonth.put(month, i);
            clientsByYear.put(year, clientByMonth);
        } else {
            HashMap<Integer, Integer> clientByMonth = clientsByYear.get(year);
            clientByMonth.put(month, i);
        }
      }
    System.out.println(clientsByYear);
  }