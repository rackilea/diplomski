List<Integer> valueList=new ArrayList<>();

    @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button10:
                    sum= sum+Integer.parseInt(btn10.getText().toString());
                    Toast.makeText(this, "Rs 10 Entered", Toast.LENGTH_SHORT).show();
                    textViewamount.setText(Integer.toString(sum) //<-- change
                    //add value to list
                   valueList.add(Integer.parseInt(btn10.getText().toString());
                    break;
                case R.id.button20:
                    sum=sum+Integer.parseInt(btn20.getText().toString());
                    Toast.makeText(this, "Rs 20 Entered", Toast.LENGTH_SHORT).show();
                    textViewamount.setText(Integer.toString(sum) 
                    //add value to list
                   valueList.add(Integer.parseInt(btn20.getText().toString());

                    break;
                case R.id.button50:
                    sum= sum+Integer.parseInt(btn50.getText().toString());
                    Toast.makeText(this, "Rs 50 Entered", Toast.LENGTH_SHORT).show();
                    textViewamount.setText(Integer.toString(sum)
                    //add value to list
                    valueList.add(Integer.parseInt(btn50.getText().toString());
                    break;
                case R.id.button100:
                    sum= sum+Integer.parseInt(btn100.getText().toString());
                    Toast.makeText(this, "Rs 100 Entered", Toast.LENGTH_SHORT).show();
                    textViewamount.setText(Integer.toString(sum) 
                    //add value to list
                    valueList.add(Integer.parseInt(btn100.getText().toString());
                    break;
                case R.id.button500:
                    sum= sum+Integer.parseInt(btn500.getText().toString());
                    Toast.makeText(this, "Rs 500 Entered", Toast.LENGTH_SHORT).show();
                    textViewamount.setText(Integer.toString(sum)
                    //add value to list
                    valueList.add(Integer.parseInt(btn500.getText().toString());
                    break;
                case R.id.button1000:
                    sum= sum+Integer.parseInt(btn1000.getText().toString());
                    Toast.makeText(this, "Rs 1000 Entered", Toast.LENGTH_SHORT).show();
                    textViewamount.setText(Integer.toString(sum)
                    //add value to list
                    valueList.add(Integer.parseInt(btn1000.getText().toString());
                    break;
                case R.id.button5000:
                    sum= sum+Integer.parseInt(btn5000.getText().toString());
                    Toast.makeText(this, "Rs 5000 Entered", Toast.LENGTH_SHORT).show();
                    textViewamount.setText(Integer.toString(sum)
                    //add value to list
                    valueList.add(Integer.parseInt(btn5000.getText().toString());
                    break;
            }