Person p = new Person();
Address a = new Address();

p.addAddress(a);

session.save(p);
session.save(a);