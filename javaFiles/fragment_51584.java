bd = bd.setScale(2, BigDecimal.ROUND_DOWN);

DecimalFormat df = new DecimalFormat();

df.setMaximumFractionDigits(2);

df.setMinimumFractionDigits(0);

df.setGroupingUsed(false);

String result = df.format(bd);