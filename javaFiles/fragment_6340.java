int precision = 10;
int i = 0;
int lastNum = 1;
boolean switcher = false;
while (i++ <= precision) {
    System.out.println(lastNum);
    lastNum += (switcher = !switcher) ? i : -i;
}