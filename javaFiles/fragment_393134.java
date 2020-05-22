String symbol1 = map.get(compound1);
    String symbol2 = map.get(compound2);

    int charge1 = Integer.parseInt(symbol1.replace("+", "").substring(
            symbol1.length() - 2));
    int charge2 = Integer.parseInt(symbol2.replace("+", "").substring(
            symbol2.length() - 2));

    String letter1 = null;
    String letter2 = null;

    if (symbol1.length() == 5) {
        letter1 = symbol1.substring(0, 2);
    } else if (symbol1.length() == 4) {
        letter1 = symbol1.substring(0, 1);
    }
    if (symbol2.length() == 5) {
        letter2 = symbol2.substring(0, 2);
    } else if (symbol2.length() == 4) {
        letter2 = symbol2.substring(0, 1);
    }

    int possitive1 = (int) Math.sqrt(charge1 * charge1);
    int possitive2 = (int) Math.sqrt(charge2 * charge2);