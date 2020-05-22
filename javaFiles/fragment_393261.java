plot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.RIGHT).setFormat(new Format() {
            @Override
            public StringBuffer format(Object seriesVal, StringBuffer stringBuffer,
                    FieldPosition fieldPosition) {

                // do whatever you need to do here.
                stringBuffer.append(((Number) seriesVal).doubleValue() + "bla");
                return stringBuffer;
            }

            @Override
            public Object parseObject(String s, ParsePosition parsePosition) {
                // nothing to do here
                return null;
            }
        });