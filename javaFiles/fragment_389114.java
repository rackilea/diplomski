// For Object A
DecimalFormat dfForObjA = new DecimalFormat("#.#####");
dfForObjA.setRoundingMode(RoundingMode.CEILING);
for (double d : A) {   // Assuming A is already declared and initialized
    System.out.println(dfForObjA.format(d));
}

// For Object B
DecimalFormat dfForObjB = new DecimalFormat("#.##");
dfForObjB.setRoundingMode(RoundingMode.CEILING);
for (double d : B) {   // Assuming B is already declared and initialized
    System.out.println(dfForObjB.format(d));
}