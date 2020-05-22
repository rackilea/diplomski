/**
 * Special URL token that gets passed from the crawler to the servlet filter.
 * This token is used in case there are already existing query parameters.
 */
private static final String ESCAPED_FRAGMENT_FORMAT1 = "_escaped_fragment_=";
private static final int ESCAPED_FRAGMENT_LENGTH1 = ESCAPED_FRAGMENT_FORMAT1.length();
/**
 * Special URL token that gets passed from the crawler to the servlet filter.
 * This token is used in case there are not already existing query parameters.
 */
private static final String ESCAPED_FRAGMENT_FORMAT2 = "&"+ESCAPED_FRAGMENT_FORMAT1;
private static final int ESCAPED_FRAGMENT_LENGTH2 = ESCAPED_FRAGMENT_FORMAT2.length();

private class SyncAllAjaxController extends NicelyResynchronizingAjaxController
{
  private static final long serialVersionUID = 1L;
  @Override
  public boolean processSynchron(HtmlPage page, WebRequest request, boolean async)
  {
      return true;
  }
}

private WebClient webClient = null;

private static final long _pumpEventLoopTimeoutMillis = 200;
private static final long _jsTimeoutMillis = 200;
private static final long _pageWaitMillis = 100;
final int _maxLoopChecks = 2;

public void destroy()
{
  if (webClient != null)
    webClient.closeAllWindows();
}

public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
    throws IOException, ServletException
{
  // Grab the request uri and query strings.
  final HttpServletRequest httpRequest = (HttpServletRequest) request;
  final String requestURI = httpRequest.getRequestURI();
  final String queryString = httpRequest.getQueryString();
  final HttpServletResponse httpResponse = (HttpServletResponse) response;

  if ((queryString != null) && (queryString.contains(ESCAPED_FRAGMENT_FORMAT1)))
  {
    // This is a Googlebot crawler request, let's return a static indexable html page
    // post javascript execution, as rendered in the browser.

    final String domain = httpRequest.getServerName();
    final int port = httpRequest.getServerPort();

    // Rewrite the URL back to the original #! version
    //   -- basically remove _escaped_fragment_ from the query. 
    // Unescape any %XX characters as need be.
    final String urlStringWithHashFragment = requestURI + rewriteQueryString(queryString);
    final String protocol = httpRequest.getProtocol();
    final URL urlWithHashFragment = new URL(protocol, domain, port, urlStringWithHashFragment);
    final WebRequest webRequest = new WebRequest(urlWithHashFragment);

    // Use the headless browser to obtain an HTML snapshot.
    webClient = new WebClient(BrowserVersion.FIREFOX_3_6);
    webClient.getCache().clear();
    webClient.setJavaScriptEnabled(true);
    webClient.setThrowExceptionOnScriptError(false);
    webClient.setRedirectEnabled(false);
    webClient.setAjaxController(new SyncAllAjaxController());
    webClient.setCssErrorHandler(new SilentCssErrorHandler());

    if (_logger.isInfoEnabled())
      _logger.info("HtmlUnit starting webClient.getPage(webRequest) where webRequest = " + webRequest.toString());
    final HtmlPage page = webClient.getPage(webRequest);

    // Important!  Give the headless browser enough time to execute JavaScript
    // The exact time to wait may depend on your application.

    webClient.getJavaScriptEngine().pumpEventLoop(_pumpEventLoopTimeoutMillis);

    int waitForBackgroundJavaScript = webClient.waitForBackgroundJavaScript(_jsTimeoutMillis);
    int loopCount = 0;
    while (waitForBackgroundJavaScript > 0 && loopCount < _maxLoopChecks)
    {
      ++loopCount;
      waitForBackgroundJavaScript = webClient.waitForBackgroundJavaScript(_jsTimeoutMillis);
      if (waitForBackgroundJavaScript == 0)
      {
        if (_logger.isTraceEnabled())
          _logger.trace("HtmlUnit exits background javascript at loop counter " + loopCount);
        break;
      }
      synchronized (page) 
      {
        if (_logger.isTraceEnabled())
            _logger.trace("HtmlUnit waits for background javascript at loop counter " + loopCount);
        try
        {
          page.wait(_pageWaitMillis);
        }
        catch (InterruptedException e)
        {
          _logger.error("HtmlUnit ERROR on page.wait at loop counter " + loopCount);
          e.printStackTrace();
        }
      }
    }
    webClient.getAjaxController().processSynchron(page, webRequest, false);
    if (webClient.getJavaScriptEngine().isScriptRunning())
    {
      _logger.warn("HtmlUnit webClient.getJavaScriptEngine().shutdownJavaScriptExecutor()");
      webClient.getJavaScriptEngine().shutdownJavaScriptExecutor();
    }

    // Return the static snapshot.
    final String staticSnapshotHtml = page.asXml();
    httpResponse.setContentType("text/html;charset=UTF-8");
    final PrintWriter out = httpResponse.getWriter();
    out.println("<hr />");
    out.println("<center><h3>Page non-interactive pour le crawler.");
    out.println("La page interactive est: <a href=\""
        + urlWithHashFragment
        + "\">"
        + urlWithHashFragment + "</a></h3></center>");
    out.println("<hr />");
    out.println(staticSnapshotHtml);
    // Close web client.
    webClient.closeAllWindows();
    out.println("");
    out.flush();
    out.close();
    if (_logger.isInfoEnabled())
      _logger.info("HtmlUnit completed webClient.getPage(webRequest) where webRequest = " + webRequest.toString());
  }
  else
  {
    if (requestURI.contains(".nocache."))
    {
      // Ensure the gwt nocache bootstrapping file is never cached.
      // References:
      //   http://stackoverflow.com/questions/4274053/how-to-clear-cache-in-gwt
      //   http://seewah.blogspot.com/2009/02/gwt-tips-2-nocachejs-getting-cached-in.html
      // 
      final Date now = new Date();
      httpResponse.setDateHeader("Date", now.getTime());
      httpResponse.setDateHeader("Expires", now.getTime() - 86400000L); // One day old.
      httpResponse.setHeader("Pragma", "no-cache");
      httpResponse.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    }

    filterChain.doFilter(request, response);
  }
}

/**
 * Maps from the query string that contains _escaped_fragment_ to one that
 * doesn't, but is instead followed by a hash fragment. It also unescapes any
 * characters that were escaped by the crawler. If the query string does not
 * contain _escaped_fragment_, it is not modified.
 * 
 * @param queryString
 * @return A modified query string followed by a hash fragment if applicable.
 *         The non-modified query string otherwise.
 * @throws UnsupportedEncodingException
 */
private static String rewriteQueryString(String queryString)
    throws UnsupportedEncodingException
{
  // Seek the escaped fragment.
  int index = queryString.indexOf(ESCAPED_FRAGMENT_FORMAT2);
  int length = ESCAPED_FRAGMENT_LENGTH2;
  if (index == -1)
  {
    index = queryString.indexOf(ESCAPED_FRAGMENT_FORMAT1);
    length = ESCAPED_FRAGMENT_LENGTH1;
  }
  if (index != -1)
  {
    // Found the escaped fragment, so build back the original decoded one.
    final StringBuilder queryStringSb = new StringBuilder();
    // Add url parameters if any.
    if (index > 0)
    {
      queryStringSb.append("?");
      queryStringSb.append(queryString.substring(0, index));
    }
    // Add the hash fragment as a replacement for the escaped fragment.
    queryStringSb.append("#!");
    // Add the decoded token.
    final String token2Decode = queryString.substring(index + length, queryString.length());
    final String tokenDecoded = URLDecoder.decode(token2Decode, "UTF-8");
    queryStringSb.append(tokenDecoded);
    return queryStringSb.toString();
  }
  return queryString;
}