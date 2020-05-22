for (int i = 0; i < orderPartsNames.size(); i++) {
            // Linear row
            LinearLayout ly = new LinearLayout(getApplicationContext());
            ly.setOrientation(LinearLayout.HORIZONTAL);
            currentLy.addView(ly, 8 + i);

            // Part name
            TextView textName = new TextView(getApplicationContext());
            textName.setText("" + orderPartsNames.get(i));
            textName.setTextSize(20);
            LinearLayout.LayoutParams lp = new LayoutParams(
                    20, LayoutParams.WRAP_CONTENT, (float) 0.34);
            textName.setLayoutParams(lp);
            ly.addView(textName);

            // Part amount
            TextView textAmount = new TextView(getApplicationContext());
            textAmount.setText("" + orderParts.get(i).getAmount());
            textAmount.setTextSize(20);
            LinearLayout.LayoutParams lp2 = new LayoutParams(
                    20, LayoutParams.WRAP_CONTENT, (float) 0.33);
            textAmount.setLayoutParams(lp2);
            ly.addView(textAmount);


            // Part price
            TextView textPrice = new TextView(getApplicationContext());
            textPrice.setText("" + orderParts.get(i).getPricePerUnit());
            textPrice.setTextSize(20);
            LinearLayout.LayoutParams lp3 = new LayoutParams(
                    100, LayoutParams.WRAP_CONTENT);
            textPrice.setLayoutParams(lp3);
            ly.addView(textPrice);

        }