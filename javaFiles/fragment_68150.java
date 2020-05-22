@Factory
  static class RemotingConfigTest extends Specification {

    @Singleton
    @Replaces(bean = OfferLeadService.class, factory = RemotingConfig.class)
    OfferLeadService offerLeadService() {
      return Mock(OfferLeadService)
    }

    @Singleton
    @Replaces(bean = APIKeyService.class, factory = RemotingConfig.class)
    APIKeyService apiKeyService() {
      return Mock(APIKeyService)
    }
  }