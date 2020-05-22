int a = 2, b = 3, c = 0;
int tmp1 = a++; //tmp1 = 2, a = 3
int tmp2 = --b; //tmp2 = 2, b = 2
int tmp3 = b++; //tmp3 = 2, b = 3
int tmp4 = ++a; //tmp4 = 4, a = 4
c = tmp1 * tmp2 - tmp3 + tmp4; // c = 2 * 2 - 2 + 4 = 6