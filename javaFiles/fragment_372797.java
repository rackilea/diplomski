final SeoClickableCell cell = new SeoClickableCell();
    Column<WebmasterObject, String> nameColumn = new Column<WebmasterObject, String>(cell) {
        @Override
        public String getValue(WebmasterObject wbo) {
            return wbo.getName();
        }
    };