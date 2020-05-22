Long val = Long.MAX_VALUE;//set your own value, I used to check if it works
Long min = Long.MIN_VALUE;
Long max = Long.MAX_VALUE;
Long step = 1L;

SpinnerNumberModel model = new SpinnerNumberModel(val, min, max, step);
JSpinner spinner = new JSpinner(model);