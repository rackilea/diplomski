RequestConfig config = RequestConfig.custom()
                .setCircularRedirectsAllowed(true)
                .build();
        httpClient = HttpClients.custom()
                .setDefaultRequestConfig(config)
                .setMaxConnPerRoute(100)
                .build();
        CookieStore cookieStore = new BasicCookieStore();
        httpContext = new BasicHttpContext();
        httpContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);

HttpGet httpget = new HttpGet(url);
        httpget.setHeader("User-Agent", "Whatever");
        StringBuilder page = new StringBuilder("");
        try {
            CloseableHttpResponse response = httpClient.execute(httpget, httpContext);
            System.out.println(response.getStatusLine());
            Scanner sc = new Scanner(response.getEntity().getContent());
            while (sc.hasNext())
                page.append(sc.nextLine()).append(" ");
            sc.close();
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return page.toString();