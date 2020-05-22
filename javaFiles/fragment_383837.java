Set<Provider.Service> services = pkcs11provider.getServices();

services.forEach(service ->
{
    // System.out.println(service.getType()); // --> Look for 'SecureRandom' type
    System.out.println(service.getAlgorithm());
});