REXP res = re.eval("result$dif.com$difference");
int[] x = res.asIntArray();

for (int i = 0; i < x.length; i++) {
  System.out.println(x[i]);
}