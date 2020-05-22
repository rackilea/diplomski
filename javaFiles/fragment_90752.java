mainLoop:
while (goal <= 100) {
   for (int i = 0; i < goal; i++) {
      if (points > 50) {
         break mainLoop;
      }
      points += i;
   }
}