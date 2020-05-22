Cat cat1 = (Cat) session.load(1);
Cat cat2 = (Cat) session.load(2);
Cat cat3 = (Cat) session.load(3);

cat1.meow(); // this will cause Hibernate to run a query to load cat1's data
cat2.meow(); // this will cause Hibernate to run a query to load cat2's data

// After this cat3 is still an uninitiated proxy because it has not been used