EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu");
try {
    // rest of your application here
}
finally {
    factory.close();
}