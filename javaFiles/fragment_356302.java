try
        {
            String[] stocks =
            {
                "GOOG", "MSFT"
            }; //
            URL yahoofinance = new URL("http://finance.yahoo.com/d/quotes.csv?s=" + stocks[0] + "+" + stocks[1] + "&f=hg");
            URLConnection yc = yahoofinance.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
            {
                System.out.println(inputLine);
            }
            in.close();
        } catch (IOException ex)
        {
            System.out.println("Oops bad things happens");
        }