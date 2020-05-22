// To trigger the fetch
List<Filter> filters = new ArrayList<Filter>(product.getFilters());
entityManager.detach(product);
product.setId(null);
product.setFilters(filters);
productService.save(product);