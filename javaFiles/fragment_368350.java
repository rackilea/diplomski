switch ((ng-ng/100+10)/10)
{
    case 10:
        lg = "A";
        break;
    case 9:
        lg = "B";
        break;
    case 8:
        lg = "C";
        break;
    case 7:
        lg = "D";
        break;
    case 6: case 5: case 4: 
    case 3: case 2: case 1:
        lg = "F";
        break;
    default:
        System.out.println("Polite Error");
        lg = "";
}