double[] boxes = {20, 10, 5, 40, 20, 41, 41, 2, 6, 7, 3, 4, 5, 6, 23, 34, 7, 8, 2, 2};
double heaviest = -1;
int count = 0;
double sum = 0;
for (double box : boxes) {
    sum += box;
    if (box > heaviest) {
        count = 1;
        heaviest = box;
    } else if (box == heaviest) {
        count++;
    }
}

// double total = sum * 2 - heaviest * count * 2 + heaviest * count * 3.5;
double total = sum * 2 + heaviest * count * 1.5;
System.out.println("total: " + total);