DecimalFormat df = new DecimalFormat("00");
long endTime = System.currentTimeMillis();
long diff = endTime - startTime;
int h = (int) (diff) / (60*60*1000);
diff -= h * (60*60*1000);
int m = (int) (endTime-startTime) / (60*1000);
diff -= m * (60 * 1000);
int s = (int) (diff / 1000);

time.setText(df.format(h) + ":" + df.format(m)
    + ":" + df.format(s));
revalidate();
repaint();