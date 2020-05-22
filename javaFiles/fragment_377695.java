datastore.save(b);
try {
    datastore.save(a);
} catch (Exception e) {
   datastore.delete(b);
}