CriteriaBuilder cb = this.em.getCriteriaBuilder();
CriteriaQuery<Long> c = cb.createQuery(Long.class);//the query returns a long, and not Orders
Root<Order> order = c.from( Order.class );
//c.select(cb.countDistinct(order));//and this is the code you were looking for
c.select(cb.countDistinct(order.get("orderID")));//for counting distinct fields other than the primary key
Path<String> customerID = order.get( "customerID" );
c.where( cb.equal( customerID, theId ) );