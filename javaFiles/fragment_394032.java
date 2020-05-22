@Transactional(propagation = Propagation.REQUIRES_NEW)
public synchronized Product getOrCreateProductWithSynchronization(final String productName, final String productDescr) {

  Product product = findProduct(productName);
  if (product != null) {
    return product;
  }

  product = new Product(productName, productDescr);
  em.persist(product);

  return product;
}


@Transactional(propagation = Propagation.REQUIRES_NEW)
public Product getOrCreateProductWithDoubleCheckedLocking(final String productName, final String productDescr) {

  Product product = findProduct(productName);
  if (product != null) {
    return product;
  }

  synchronized (this) {
    product = findProduct(productName);
    if (product != null) {
      return product;
    }

    product = new Product(productName, productDescr);
    em.persist(product);
  }

  return product;
}


@Retryable(include = DataIntegrityViolationException.class, maxAttempts = 2)
@Transactional(propagation = Propagation.REQUIRES_NEW)
public Product getOrCreateProductWithRetryable(final String productName, final String productDescr) {

  Product product = findProduct(productName);
  if (product != null) {
    return product;
  }

  product = new Product(productName, productDescr);
  em.persist(product);
  return product;
}


private Product findProduct(final String productName) {
  // try to find an existing product by name or return null
}