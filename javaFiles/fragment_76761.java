add these lines..
session =sessionFactory.openSession();
Transaction tx = session.beginTransaction(); //new line
Item item = new Item();



session.save(item);
 System.out.println("Done");
 tx.commit(); //new line
 }catch(Exception e){
...