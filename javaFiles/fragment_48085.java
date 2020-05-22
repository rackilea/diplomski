public Flux<ProdModel> createAllCGs(List<Product> prodList) {
      return Flux.fromIterable(prodList)
            .map(
                prodModel -> {
                  System.out.println("Input Data VM ::: " + prodModel);
                  return getProdModel(reviewModel);
                })
            .delayElements(Duration.ofSeconds(3));
    }

    private getProdModel getProdModel(ProdModel prodModel) {
        logger.debug("Time Now: {}", LocalDate.now());
        ProdModel cgModel = new CGModel();
        cgModel.setCgName("some Name");
        cgModel.setMessage("some meaningful message");
        cgModel.setTimestamp(LocalDateTime.now().toString());
        return cgModel;
  }