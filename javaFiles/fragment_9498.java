import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    String jsonInput = readJsonInput(new File("input.json"));
    JSONArray jquotes = new JSONArray(jsonInput);
    int length = jquotes.length();
    List<Quote> quotes = new ArrayList<Quote>(length);
    if (length > 0)
    {
      for (int i = 0; i < length; i++)
      {
        JSONObject quote = jquotes.getJSONObject(i);

        Quote myQuote = new Quote();
        myQuote.setName(quote.getString("companyname"));
        myQuote.setSymbol(quote.getString("symbol"));
        myQuote.setLastTradePriceOnly(quote.getString("last"));
        myQuote.setChange(quote.getString("change"));
        myQuote.setPercentChange(quote.getString("percentchange"));

        quotes.add(myQuote);
      }
    }
    System.out.println(quotes);
  }

  private static String readJsonInput(File inputFile) throws Exception
  {
    StringBuilder result = new StringBuilder();
    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    for (String line = null; (line = reader.readLine()) != null;)
    {
      result.append(line);
    }
    return result.toString();
  }
}

class Quote
{
  private String name;
  private String percentChange;
  private String change;
  private String lastTradePriceOnly;
  private String symbol;

  void setName(String name)
  {
    this.name = name;
  }

  void setPercentChange(String percentChange)
  {
    this.percentChange = percentChange;
  }

  void setChange(String change)
  {
    this.change = change;
  }

  void setLastTradePriceOnly(String lastTradePriceOnly)
  {
    this.lastTradePriceOnly = lastTradePriceOnly;
  }

  void setSymbol(String symbol)
  {
    this.symbol = symbol;
  }

  @Override
  public String toString()
  {
    return String.format(
        "{Quote: name=%s, percentChange=%s, change=%s, lastTradePriceOnly=%s, symbol=%s}",
        name, percentChange, change, lastTradePriceOnly, symbol);
  }
}