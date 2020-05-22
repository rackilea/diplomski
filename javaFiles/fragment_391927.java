if (view instanceof Window) {

        Window win = (Window) view;
        PageCtrl pc = (PageCtrl) win.getPage();
        pc.addBeforeHeadTags("<script type=\"text/javascript\">" + "(function(i,s,o,g,r,a,m)"
                + "{i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){"
                + "(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();" + "a=s.createElement(o),"
                + "m=s.getElementsByTagName(o)[0];" + "a.async=1;a.src=g;m.parentNode.insertBefore(a,m)" + "})"
                + "(window,document,'script','//www.google-analytics.com/analytics.js','ga');" + "ga('create', "
                + this.trackingID + ", 'auto'); " + "ga('send', 'pageview');" + "</script>");

    } else {
        throw new UiException("This view model must be applied from a Window component.");
    }