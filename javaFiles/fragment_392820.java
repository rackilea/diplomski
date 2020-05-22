CloseableHttpClient client = HttpClients.custom()
        .setRoutePlanner(new DefaultRoutePlanner(DefaultSchemePortResolver.INSTANCE) {

            @Override
            public HttpRoute determineRoute(
                    final HttpHost target,
                    final HttpRequest request,
                    final HttpContext context) throws HttpException {
                return super.determineRoute(
                        target.getHostName().equals("overhere") ? new HttpHost("overthere", -1, "https") : target,
                        request,
                        context);
            }
        })
        .build();