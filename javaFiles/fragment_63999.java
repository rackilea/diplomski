for (Provider provider: Security.getProviders()) {
    System.out.println(provider.getName());
    for (Provider.Service s: provider.getServices()){
        if (s.getType().equals("Cipher"))
            System.out.println("\t"+s.getType()+" "+ s.getAlgorithm());
    }
}