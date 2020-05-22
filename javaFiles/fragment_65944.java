int ninediceproduct = ninedice;
int sixdiceproduct = sixdice;
while(ninediceproduct > 0){
    ninediceproduct *= (int) Math.ceil(Math.random () * (9-1)+ 1);
    ninediceproduct--;
}
while(sixdiceproduct > 0){
    sixdiceproduct *= (int) Math.ceil(Math.random () * (6-1)+ 1);
    sixdiceproduct--;
}