boolean found7 = false;
boolean found9 = false;
for (int ii = i; ii > 0: ii /= 10)  {
  switch (ii % 10) {
    case 7: found7 = true; break;
    case 9: found9 = true; break;
  }
}

if (found7 && found9) {
  count++;
}