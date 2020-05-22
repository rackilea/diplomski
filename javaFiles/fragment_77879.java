super.onActivityCreated(savedInstanceState);

            // restore webview state
            WebView webView = (WebView) mRootView.findViewById(R.id.fragment_main_webview);
            if(savedInstanceState!=null)
            {

                    webView.restoreState(savedInstanceState);
            }

            // setup webview
            renderView();

            webView.getSettings().setUserAgentString("my-app");