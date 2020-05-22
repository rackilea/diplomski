InfiniteProgress prog = new InfiniteProgress();
final Dialog dlg = prog.showInifiniteBlocking();
final WebBrowser wb = findLoginWebBrowser();
((BrowserComponent) wb.getInternal()).setBrowserNavigationCallback(
    new BrowserNavigationCallback() {
        public boolean shouldNavigate(String url) {
            //your condition
            if(xyz){
                Display.getInstance().callSerially(new Runnable() {
                    public void run() {
                        //do whatever you wants
                        dlg.dispose();
                    }
                });
            }
        }
    }
);