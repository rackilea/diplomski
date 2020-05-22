@Provides
@Singleton
fun provideTokenHolder(service:TokenService): TokenHolder{
    return TokenHolder(service)
}

@Provides
@Singleton
fun provideTokenService(retrofit: Retrofit): TokenService{
    return retrofit.create(TokenService::class.java)
}