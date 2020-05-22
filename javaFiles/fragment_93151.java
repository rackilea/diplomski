char calculate(int[] scores) {
  double averageScore = Arrays.stream(scores).average().getAsDouble();
  int nearestMultipleOfFive = 5 * ((int) averageScore / 5);
  switch (nearestMultipleOfFive) {
    case 100:
    case 95: 
    case 90: return 'O';
    case 85:
    case 80: return 'E';
    case 75: 
    case 70: return 'A';
    case 65: 
    case 60:
    case 55: return 'P';
    case 50: 
    case 45:
    case 40: return 'D';
    default: return 'E';
  }
}