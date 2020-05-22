@Provides
@Singleton
@Named("authRetrofit")
public Retrofit provideAuthRetrofit() {
  // setup retrofit for authentication
  return retrofit;
}

@Provides
@Singleton
@Named("paymentRetrofit")
public Retrofit providePaymentRetrofit() {
  // setup retrofit for payments
  return retrofit;
}