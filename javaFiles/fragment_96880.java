double sum_w_value = 0d;
double sum_d_value = 0d;
Cursor sum_w = mydb.sumwithdraw();
Cursor sum_d = mydb.sumdeposit();
if (sum_w.moveToNext() ){
    sum_w_value = sum_w.getDouble(sum_w.getColumnIndex("myTotal_withdraw"));
}

if (sum_d.moveToNext() ){
    sum_d_value = sum_d.getDouble(sum_d.getColumnIndex("myTotal_deposit"));
}

bal = sum_d_value - sum_w_value

if (val<bal){
    Toast.makeText(this, "Insufficeient funds", Toast.LENGTH_SHORT).show();
}