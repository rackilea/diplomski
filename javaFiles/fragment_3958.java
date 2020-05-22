for (String string : new String[] {"1.1245", "1.1244", "1.1235", "1.1249", "1.1299"}) {
        BigDecimal a = new BigDecimal(string);

        if (a.setScale(2, BigDecimal.ROUND_HALF_UP).subtract(a).compareTo(new BigDecimal("-0.0044")) < 0)  {
            System.out.println(string + ":" + a.add(new BigDecimal("0.001")).setScale(2, BigDecimal.ROUND_HALF_UP));
        } else {
            System.out.println(string + ":" + a.setScale(2, BigDecimal.ROUND_HALF_UP));
        }
    }