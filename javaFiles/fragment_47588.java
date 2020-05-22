JAXBContext jaxbContext = JAXBContext.newInstance(GetProductListResponse.class);
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

    JAXBElement<GetProductListResponse> root = jaxbUnmarshaller.unmarshal(new StreamSource(
            file), GetProductListResponse.class);
    GetProductListResponse productListResponse = root.getValue();