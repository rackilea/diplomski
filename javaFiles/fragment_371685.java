private static Retrofit getValidatedDomainObjectsRetrofit() {
    return new Retrofit.Builder()
            .client(mockOkHttpClient)
            .baseUrl("http://whatever")
            .addConverterFactory(new Converter.Factory() {
                @Override
                public Converter<?, RequestBody> requestBodyConverter(final Type type, final Annotation[] parameterAnnotations,
                        final Annotation[] methodAnnotations, final Retrofit retrofit) {
                    if ( type != User.class ) {
                        return null;
                    }
                    final Converter<Object, RequestBody> nextConverter = retrofit.nextRequestBodyConverter(this, type, parameterAnnotations, methodAnnotations);
                    return (Converter<Object, RequestBody>) value -> {
                        if ( value instanceof User ) {
                            final User user = (User) value;
                            requireNonNull(user.name, "name must not be null");
                            requireNonNull(user.group, "group must not be null");
                        }
                        return nextConverter.convert(value);
                    };
                }

            })
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}