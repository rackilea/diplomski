return Optional.<Product>of(product)
        .map(Product::getServiceAttributes)
        .map(ServiceAttributeMap::getMap)
        .map((v) -> (ServiceAttribute) v.get(attributeV.getAttributeString()))
        .map(c::getValueList)
        .flatMap(values -> values
            .stream()
            .filter((attribute) -> StringUtils.equals(attribute.getFoo(), attributeV.getBar()))
            .findFirst())
        .map(x -> x.bar());