public Time(double input){
    number=  input;
    //double temp ; This should be deleted


    this.temp =  (number%1*60*100)/100; 
    minutes= (int)temp;
    hours= (int)number-(int)number%1;

}