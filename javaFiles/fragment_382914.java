import java.util.Scanner;

public class StockTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /*
         * Make sureto complete the Stock class before you do the following
         * items.
         */

        /*
         * Step 1: Instantiate two Stock objects with arguments of your
         * choice(stock symbol and name). Using two set methods set the
         * previousClosingPrice and curentPrice of two Stocks. Display the
         * percentage changed from previousClosingPrice to curentPrice of both
         * stocks.
         */
        System.out.println("Input stock symbol");
        String symbol = input.nextLine();
        System.out.println("Input stock name");
        String name = input.nextLine();

        Stock stock1 = new Stock(symbol, name);

        System.out.println("Input previous price");
        stock1.setPreviousClosingPrice(Double.parseDouble(input.nextLine()));
        System.out.println("Input current price");
        stock1.setCurrentPrice(Double.parseDouble(input.nextLine()));

        System.out.println("Input stock symbol");
        symbol = input.nextLine();
        System.out.println("Input stock name");
        name = input.nextLine();

        Stock stock2 = new Stock(symbol, name);

        System.out.println("Input previous price");
        stock2.setPreviousClosingPrice(Double.parseDouble(input.nextLine()));
        System.out.println("Input current price");
        stock2.setCurrentPrice(Double.parseDouble(input.nextLine()));

        System.out.println("the change percentage of the stock is "
                + stock1.getChangePercent() + "%");
        System.out.println("the change percentage of the stock is "
                + stock2.getChangePercent() + "%");

        /*
         * Step 2: Declare an array of 5 Stock objects. (Next three steps should
         * be done in a loop) Ask the user to input stock symbol, name,
         * previousClosingPrice and curentPrice. Initialize an array element
         * with new Stock object using symbol and name that user input. Using
         * two set methods set the previousClosingPrice and curentPrice of each
         * Stock element
         */
        Stock[] stockArray = new Stock[2];

        for (int i = 0; i < stockArray.length; i++) {
            System.out
                    .println("Please input stock symbol, name, previous price, and current price");

            symbol = input.nextLine();
            name = input.nextLine();

            Stock stock = new Stock(symbol, name);
            stock.setPreviousClosingPrice(Double.parseDouble(input.nextLine()));
            stock.setCurrentPrice(Double.parseDouble(input.nextLine()));

            stockArray[i] = stock;
        }

        /*
         * Step 4: (this step should be done in a loop) Display the percentage
         * changed from previousClosingPrice to curentPrice of all stocks with
         * their symbol.
         */
        for (Stock stock : stockArray) {
            System.out.println("Percentage changed of " + stock.getSymbol()
                    + " " + stock.getChangePercent() + "%");
        }
    }
}