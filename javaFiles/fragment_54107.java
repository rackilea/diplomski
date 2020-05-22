int index = 0;

for (String amount : amountArray)
    {
        barEntries.add(new BarEntry(index, Float.parseFloat(amount)));
        index++;
    }