private static final OkHttpClient mockOkHttpClient = new OkHttpClient.Builder()
        .addInterceptor(chain -> new Response.Builder()
                .request(chain.request())
                .protocol(HTTP_1_0)
                .code(HTTP_OK)
                .body(ResponseBody.create(MediaType.parse("application/json"), "\"OK\""))
                .build()
        )
        .build();