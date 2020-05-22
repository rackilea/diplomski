Query q = pm.newQuery(Product.class);
try {
  List<Product> results = (List<Product>) q.execute();
  if (!results.isEmpty()) {
    for (Product p : results) {
      // Process result p
    }
  } else {
    // Handle "no results" case
  }
} finally {
  q.closeAll();
}