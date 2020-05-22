@Bean
public UrlRewriteFilter getUrlRewriteFilter() {
    log.debug("Calling Bean URL Rewrite Filter");
    UrlRewriteFilter urlRewriteFilter = new UrlRewriteFilter();
    return urlRewriteFilter;
}