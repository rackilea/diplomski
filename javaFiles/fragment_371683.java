final Iterable<Retrofit> retrofits = ImmutableList.of(
        getAsIsRetrofit(),
        getValidatedDomainObjectsRetrofit(),
        getValidatedDataTransferObjectsRetrofit()
);
final User user = new User("user", "group");
for ( final Retrofit retrofit : retrofits ) {
    final IService service = retrofit.create(IService.class);
    final String message = service.post(user).execute().body();
    System.out.println(message);
}