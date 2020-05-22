DecimalFormat df = new DecimalFormat("00");
long endTime = System.currentTimeMillis();
long diff = endTime - startTime.getTimeInMillis();
int h = (int) (diff) / (60 * 60 * 1000);
diff -= h * (60 * 60 * 1000);
int m = (int) (endTime - startTime.getTimeInMillis()) / (60 * 1000);
diff -= m * (60 * 1000);
int s = (int) (diff / 1000);