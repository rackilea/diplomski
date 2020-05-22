int count = 0;
int sum = 0;
for (Person p : persons2) {
   ++count;
   sum += p.getScoreTheo();
}

double average = sum / (double)count;