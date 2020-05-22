OrderBill cheapOrder = new OrderBill(5, LocalDate.now());
weekRep.addWeek(cheapOrder.getOrderWeek());
//because of the cascade, both the cheapOrder and the week or now persisted in the DB and managed by weekRep

OrderBill dbOrder = orderRep.updateOrder(cheapOrder);
boolean t2 = weekRep.isManaged(cheapOrder); //true
boolean t3  = orderRep.isManaged(cheapOrder); //false
//It's because this returns false I assume both persistence contexts are different
boolean t4 =  orderRep.isManaged(dbOrder); //true
//If i now use "cheapOrder" to change the order i get the error
//If i now use "dbOrder" to change the order, db gets updated as expected