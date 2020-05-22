- (BOOL)webView:(UIWebView*)webView shouldStartLoadWithRequest:(NSURLRequest*)request navigationType:(UIWebViewNavigationType)navigationType {
    NSURL *url = [request URL];
    if (navigationType == UIWebViewNavigationTypeLinkClicked) {
            if ([[url scheme] isEqualToString:@"click"]) {
               // do whatever you want here to happen after the click
            }
            return NO;
    } else {
       return YES;
    }
}