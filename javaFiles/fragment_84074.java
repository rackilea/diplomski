String[] item = new String[] { "Audi", "BMW", "VW", "Ferrari", "Cherry QQ" };
float[] price = new float[] { 18000.0f, 24000.0f, 2100.50f, 786400.1f, 120.70f };

for (int i = 0; i < price.length; i++) {
    System.out.printf("%2d. %-10s €%.2f\n", i + 1, item[i], price[i]);
}