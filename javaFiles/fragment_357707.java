FluentIterable
       .from(database.getClientList())
       .filter(activeInLastMonth())
       .transform(Functions.toStringFunction())
       .limit(10)
       .toList();