double base = 1;
double factor = 1.1;

for (double score : Arrays.asList(1.0, 1.1, 1.3, 8.6, 9.46))
{
   int level = (int) (Math.log(score / base) / Math.log(factor));
   System.out.println(level);
}