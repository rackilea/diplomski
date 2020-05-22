ODatabaseObjectTx db = new ODatabaseObjectTx("local:/temp/db");
db.create();

db.getEntityManager().registerEntityClass(Order.class);
db.getEntityManager().registerEntityClass(OrderItem.class);

Order o = new Order(234);
o.items = new ArrayList<OrderItem>();
o.items.add( new OrderItem('mouse', 10, 12.5) );

db.save( o );