if ((havingDinner.equals("Y") || havingDinner.equals("y")) && (ageDiscount.equals("Y") || ageDiscount.equals("y"))) {
    agetick = (grossTick * 0.85);
    dinnerTotal = dinnerPrice * (standTick + terraceTick);
    vatTotalForAge = ((dinnerTotal + agetick) * 1.21);
    System.out.println(vatTotalForAge);
} else if ((havingDinner.equals("Y") || havingDinner.equals("y")) && (ageDiscount.equals("N") || ageDiscount.equals("n"))) {
    dinnerTotal = dinnerPrice * (standTick + terraceTick);
    vatTotalNoAgeLess5 = ((dinnerTotal + grossTick) * 1.21);
    System.out.println(vatTotalNoAgeLess5);
}