String countryCode = ....;  // known in advance
QueryParser queryParser = new QueryParser(matchVersion, f, a);
Query cityNameQuery = queryParser.parse(inputWithCityName);
Query countryCodeQuery = queryParser.parse("+countrycode:" + countryCode);

BooleanQuery result = new BooleanQuery();
result.add(new BooleanClause(cityNameQuery, MUST));
result.add(new BooleanClause(countryCodeQuery, MUST));