myAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(neerslagAxis) {
            @Override
            public String toString(Number object) {
                if ((double) object < 0) {
                    return "";
                } else {
                    return ("" + object).replace(".0", "");
                }
            }
        });