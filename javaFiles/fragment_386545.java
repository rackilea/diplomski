int i = 5;
int x = ++i + --i;
//       ^
//   (i = i + 1) + --i
//   (i = 5 + 1) + --i  
//   (i = 6)     + --i
//                   ^
//        6      + (i = i - 1)
//        6      + (i = 6 - 1)
//        6      + (i = 5)
//        6      + 5
// x = 11
int y = i++ + i--;
//       ^
//    (i = 5) + i--
//         5  + i--
//     i = i + 1 // post evaluation, after i was evaluated to 5, now i increments its value and it is 6
//         5 + (i = 6)
//         5 + 6
// y = 11
//     i = i - 1 // post evaluation, after i was evaluated to 6, now i decrements its value and it is 5
System.out.println("x=" + x); // x=11
System.out.println("y=" + y); // y=11