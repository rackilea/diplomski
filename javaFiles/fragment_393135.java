int getPositive(String compound) { // I have no idea what "positive", "symbol" and compound represent, consider better names please
    String symbol = map.get(compound);
    int charge = Integer.parseInt(symbol.replace("+", "").substring(
                symbol.length() - 2));
    return (int) Math.sqrt(charge2 * charge2);
}