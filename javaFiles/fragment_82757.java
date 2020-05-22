int num=6;//num is 6 here
num=num+1;//num is 7 after this step
if (num>6)//num is greater than 6 ? YES, so below line will be executed
jTextField1.setText(Integer.toString(num));//It comes here & sets jTextField1 as 7
else
jTextField1.setText(Integer.toString(num+5));