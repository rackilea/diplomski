double total = 0;
for (Map.Entry<String, Integer> entry : order.entrySet()) {

    int quanity = entry.getValue();
    double price = prices.get(entry.getKey());

    total += quanity * price;

    System.out.println(String.format(
                    "%-20s x %4d @ %7s = %10s",
                    entry.getKey(),
                    quanity,
                    NumberFormat.getCurrencyInstance().format(price),
                    NumberFormat.getCurrencyInstance().format(quanity * price)));

}

System.out.printf("%-20s   %4s   %7s   ==========%n", "", "", "");
System.out.printf("%-20s   %4s   %7s   %10s%n", "", "", "", NumberFormat.getCurrencyInstance().format(total));