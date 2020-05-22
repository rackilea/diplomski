private static double getFractionalPart(double num) {     
       if (num > 0) {
          return num - Math.floor(num);
       } else {
          return ((num - Math.ceil(num)) * -1);
}
}