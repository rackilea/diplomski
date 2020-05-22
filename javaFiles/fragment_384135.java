String result = null;
if (bmi < 18.5) {
        System.out.print("You're " + classification[0] + "\n");
        result = classification[0];
    } else if (bmi < 25) {
        System.out.print("You're " + classification[1] + "\n");
        result = classification[1];
    } else if (bmi < 30) {
        System.out.print("You're " + classification[2] + "\n");
        result = classification[2];
    } else {
        System.out.print("You're " + classification[3] + "\n");
        result = classification[3];
    }

    switch (result) {
        case "Underweight":
            System.out.println("Underweight");
            break;
        case "Normal":
            System.out.println("Normal");
            break;
        case "Overweight":
            System.out.println("A bit overweighted");
            break;
        case "Obese":
            System.out.println("A bit obese");
            break;
        default:
            System.out.println("Ok");
            break;
    }