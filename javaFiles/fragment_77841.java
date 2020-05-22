@Provides
PTRS newPTRS(Client client, MembersInjector<PTRS> ptrsInjector){
  PTRS ptrs = new PTRS();
  ptrsInjector.injectMembers(ptrs);    // <-- inject members here
  ptrs.setGeoServiceClient(client);
  return ptrs;
}