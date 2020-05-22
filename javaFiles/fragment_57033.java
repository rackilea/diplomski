public String GetYahooSymbol(string isin)
{
    string query = GetQuery(isin);
    XDocument result = GetHttpResult(query);
    XElement stock = result.Root.Element("results").Element("stock");
    return stock.Element("Isin").Value.ToString();
}