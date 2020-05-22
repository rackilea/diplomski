System.out.printf("Symbol: %s\n"
      + "Name: %s\n"
      + "Previous Closing Price: %1.2f\n"
      + "Current Price: %1.2f\n"
      + "Change: %1.2f%%", 
      //               ^
      stock.symbol, 
      stock.name, 
      stock.previousClosingPrice,
      stock.currentPrice,
      stock.getChangePercent());