int baseAmount = gender.equals("m") ? maleGender : femaleGender;
if (carAge <= 2007) {
    System.out.println("Your total price is $" + ((acc * 100 + baseAmount ) / 2) + ".");
} else 
    System.out.println("Your total price is $" + (acc * 100 + baseAmount ) + ".");
}