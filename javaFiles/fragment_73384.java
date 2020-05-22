for (int i = 0; i < montantt.length; i++) {
    try {
        montanttt[i] = new BigDecimal(montantt[i]);
        System.out.println(montanttt[i]);
    } catch (NumberFormatException e) {
        System.out.println("Exception while parsing: " + montantt[i]);
    }
}