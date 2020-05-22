@MockBean(OfferLeadService.class)
OfferLeadService offerLeadService() {
    return Mock(OfferLeadService)
}

@MockBean(APIKeyService.class)
APIKeyService apiKeyService() {
    return Mock(APIKeyService)
}