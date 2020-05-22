System.out.print("Your BMR is:");//BMR Calculation
double BMR = 0;
if (gender == ('M')){
    BMR = 665+(6.23 * weight)+(12.7 * height)-(6.8 * age);
    System.out.println(BMR);

} else if (gender == ('F')) {
    BMR = 655+(4.35 * weight)+(4.7 * height)-(4.7 * age);
    System.out.println(BMR);

};