int planet = s.nextInt();
double newWeight;

switch(planet){
    case 1:
        newWeight = weight*0.78;
        break;
    case 2:
        newWeight = weight*0.39;
        break;
    case 3:
        newWeight = weight*2.56;
        break;
    case 4:
        newWeight = weight*1.17;
        break;
    case 5:
        newWeight = weight*1.05;
        break;
    case 6:
        newWeight = weight*1.23;
        break;
    default:
        newWeight = 0.0;
        // or
        throw new IllegalArgumentException();
}