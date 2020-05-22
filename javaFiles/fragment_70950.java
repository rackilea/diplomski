try {
            Class<?> rClass = Class.forName("com.android.internal.R$id");
//            Field timePicker = rClass.getField(name);
            TimePicker mTimePicker = (TimePicker) findViewById(id);

            Field m = rClass.getField("minute");

            NumberPicker mMinuteSpinner = (NumberPicker) mTimePicker.findViewById(m.getInt(null));
            mMinuteSpinner.setMinValue(0);
            mMinuteSpinner.setMaxValue((60 / increment) - 1);
            List<String> displayedValues = new ArrayList<String>();
            for (int i = 0; i < 60; i += increment) {
                displayedValues.add(String.format("%02d", i));
            }

            mMinuteSpinner.setDisplayedValues(displayedValues.toArray(new String[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }