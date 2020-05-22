AssetCategories categories = new AssetCategories();
        categories.add(new AssetCategory("AAPL", "US LARGE CAP VALUE", LocalDate.parse("2015-01-01"), LocalDate.parse("2015-02-17")));
        categories.add(new AssetCategory("AAPL", "US LARGE CAP GROWTH", LocalDate.parse("2015-02-18"), LocalDate.parse("2015-03-16")));
        categories.add(new AssetCategory("AAPL", "US MID CAP VALUE", LocalDate.parse("2015-08-18"), LocalDate.parse("2015-12-15")));
        categories.add(new AssetCategory("AAPL", "US LARGE CAP VALUE", LocalDate.parse("2015-03-17"), LocalDate.parse("2015-05-17")));
        categories.add(new AssetCategory("AAPL", "US MID CAP GROWTH", LocalDate.parse("2015-05-18"), LocalDate.parse("2015-08-17")));

        AssetCategory assetCategory = categories.fetchAssetCategory("AAPL", LocalDate.parse("2015-12-14"));
        boolean valid = categories.validateAssetCategory("AAPL", "US MID CAP VALUE", LocalDate.parse("2015-12-15"));