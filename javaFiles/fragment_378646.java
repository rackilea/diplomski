public Mono<Item> patch(String itemId, PatchSpecs specs)
{
    return itemRepository.findById(itemId)
                         .switchIfEmpty(Mono.error(new RuntimeException("Can not find item.")))
                         .flatMap(item -> updateAndSave(specs, item));
}

private Mono<? extends Item> updateAndSave(PatchSpecs specs, Item item)
{
    Mono<Optional<Brand>> brand = getBrand(specs.getBrandId());
    Mono<Optional<Category>> category = getCategory(specs.getCategoryId());

    return Mono.zip(Mono.just(item), brand, category)
               .flatMap(tuple -> updateAndSave(specs, tuple));
}

private Mono<Optional<Brand>> getBrand(String inputBrandId)
{
    return Mono.justOrEmpty(inputBrandId)
               .flatMap(brandId -> brandService.getById(brandId)
                                               .switchIfEmpty(Mono.error(new RuntimeException("Can not find brand."))))
               .map(Optional::of)
               .defaultIfEmpty(Optional.empty());
}

private Mono<Optional<Category>> getCategory(String inputCategoryId)
{
    return Mono.justOrEmpty(inputCategoryId)
               .flatMap(brandId -> categoryService.getById(brandId)
                                                  .switchIfEmpty(Mono.error(new RuntimeException("Can not find brand."))))
               .map(Optional::of)
               .defaultIfEmpty(Optional.empty());
}

private Mono<Item> updateAndSave(PatchSpecs specs, Tuple3<Item, Optional<Brand>, Optional<Category>> tuple)
{
    Item item = tuple.getT1();
    Brand brand = tuple.getT2().orElse(null);
    Category category = tuple.getT3().orElse(null);

    // TODO do update and save here
    return null;
}