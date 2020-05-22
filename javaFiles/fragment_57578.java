String mJsonString = m.entrySet().stream()
            .map(e -> String.format("\"%s\":%s", e.getKey(), e.getValue()))
            .collect(Collectors.joining(",", "{", "}"));

    System.out.println(mJsonString);

    final Gson gson = new GsonBuilder().create();
    StockPriceAlertResponse stockPriceAlertResponse = gson.fromJson(mJsonString,
            StockPriceAlertResponse.class);
    List<StockPriceAlert> stockPriceAlerts = stockPriceAlertResponse.getStockPriceAlerts();