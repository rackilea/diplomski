//create client
        SphereClientConfig sphereClientConfig = SphereClientConfig.of( projectKey,  clientId,  clientSecret);
        SphereClient client = SphereClient.of(sphereClientConfig, SphereClientFactory.of().createHttpClient(), SphereAccessTokenSupplier.ofConstantToken("accessToken"))
        final ByIdVariantIdentifier identifier = product.getMasterData().getStaged().getMasterVariant().getIdentifier();
        File imageFile = new File("Path to your image");

        //create update commands
        final ProductImageUploadCommand cmd1 = ProductImageUploadCommand
                .ofVariantId(imageFile, identifier)
                .withFilename("myProductImage1.gif")
                .withStaged(true);
        final ProductImageUploadCommand cmd2 = ProductImageUploadCommand
                .ofVariantId(imageFile, identifier)
                .withFilename("myProductImage2.gif")
                .withStaged(true);

        //update the product
        final Product updatedProduct1 = client().executeBlocking(cmd1);
        final Product updatedProduct = client().executeBlocking(cmd2);

        //get the images
        List<Image> images = updatedProduct.getMasterData().getStaged().getMasterVariant().getImages();