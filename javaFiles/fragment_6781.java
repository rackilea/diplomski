...
mItemName = (EditText)findViewById(R.id.edit_item_name);
mItemCost = (EditText)findViewById(R.id.item_cost);
mSellPercent = (EditText)findViewById(R.id.profit_percent);
mSellAmount = (EditText)findViewById(R.id.profit_amount);

mCalculate = (Button)findViewById(R.id.calculate_button);
item = mItemName.getText().toString();                                    
itcost = mItemCost.getText().toString();                                      
cost = Integer.parseInt(itcost);   
sellperc = mSellPercent.getText().toString();                                     
no2 = Integer.parseInt(sellperc);   
sellamou = mSellAmount.getText().toString();                            
no3 = Integer.parseInt(sellamou);