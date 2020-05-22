public class CachePostFilter extends CacheBaseFilter {

    public CachePostFilter(RedisCacheManager redisCacheManager, Properties properties) {
        super(redisCacheManager, properties);
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return super.shouldFilter() && !ctx.getBoolean(CACHE_HIT);
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        HttpServletResponse res = ctx.getResponse();

        if (isSuccess(res, ctx.getOriginResponseHeaders())) {
            // Store only successful responses

            String cacheKey = cacheKey(req);
            if (cacheKey != null) {
                String body = null;

                if (null != ctx.getResponseBody()) {
                    body = ctx.getResponseBody();
                } else if (null != ctx.getResponseDataStream()) {
                    InputStream rawInputStream = null;
                    InputStream gzipByteArrayInputStream = null;
                    try {
                        rawInputStream = ctx.getResponseDataStream();
                        gzipByteArrayInputStream = null;
                        // If origin tell it's GZipped but the content is ZERO
                        // bytes,
                        // don't try to uncompress
                        final Long len = ctx.getOriginContentLength();
                        if (len == null || len > 0) {

                            byte[] rawData = IOUtils.toByteArray(rawInputStream);

                            ctx.setResponseDataStream(new ByteArrayInputStream(rawData));

                            if (ctx.getResponseGZipped()) {
                                gzipByteArrayInputStream = new GZIPInputStream(new ByteArrayInputStream(rawData));
                            } else {
                                gzipByteArrayInputStream = new ByteArrayInputStream(rawData);
                            }

                            StringWriter writer = new StringWriter();

                            IOUtils.copy(gzipByteArrayInputStream, writer, "UTF-8");
                            body = writer.toString();
                        }

                    } catch (IOException e) {
                        logger.error("Cannot read body " + e.getMessage(), e);
                    } finally {
                        if (null != rawInputStream) {
                            try {
                                rawInputStream.close();
                            } catch (IOException e) {

                            }
                        }

                        if (null != gzipByteArrayInputStream) {
                            try {
                                gzipByteArrayInputStream.close();
                            } catch (IOException e) {

                            }
                        }
                    }

                    // if we read from the stream, the other filter cannot read
                    // and they dont' deliver any response
                    // ctx.setResponseBody(body);
                    // ctx.setResponseGZipped(false);

                    saveToCache(ctx, cacheKey, body);
                }
            }
        }
        return null;

    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public String filterType() {
        return "post";
    }

    private boolean isSuccess(HttpServletResponse res, List<Pair<String, String>> originHeaders) {
        if (res != null && res.getStatus() == 200) {
            if (null != originHeaders) {
                for (Pair<String, String> header : originHeaders) {
                    if (header.first().equals("X-CACHEABLE") && header.second().equals("1")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}