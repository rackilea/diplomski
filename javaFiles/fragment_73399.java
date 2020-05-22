@PutMapping("products/{productId}")
public ProductResponse updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductForm productForm) {
    Optional<Product> foundProductOpt = productRepository.findById(productId);
    Product foundProduct = foundProductOpt.orElseThrow(() -> new EntityNotFoundException("productId" + productId + "not found."));
    org.apache.commons.beanutils.BeanUtils.copyProperties(foundProduct, productForm); 
    productRepository.save(foundProduct);
    return new ProductResponse(null, "product updated");
}