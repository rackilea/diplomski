@Override
    public void onClick(View v) {
        if ((IdText.getText().toString()).isEmpty())
        {
            IdText.setError("Please fill out your ID");
            return;
        }

        else if ((NameText.getText().toString()).isEmpty())
        {
            NameText.setError("Please fill out your Name");
            return;
        }

        else if ((AgeText.getText().toString()).isEmpty())
        {
            AgeText.setError("Please fill out your Age");
            return;
        }

        else if ((HeightText.getText().toString()).isEmpty())
        {
            HeightText.setError("Please fill out your Height in centimeters");
            return;
        }

        else if ((WeightText.getText().toString()).isEmpty())
        {
            WeightText.setError("Please fill out your weight in kilos");
            return;
        }

        else if ((ReachText.getText().toString()).isEmpty())
        {
            ReachText.setError("Please fill out your reach in inches");
            return;
        }
        else{
            boolean isInserted = dbHandler.insertData(IdText.getText().toString(),

                    NameText.getText().toString(),
                    AgeText.getText().toString(),
                    HeightText.getText().toString(),
                    WeightText.getText().toString(),
                    ReachText.getText().toString());
            if (isInserted == true)
                Toast.makeText(MainActivity.this, "Fighter added", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_LONG).show();
            }
    }