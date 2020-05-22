1775           static File generateFile(String prefix, String suffix, File dir) {
 1776               long n = random.nextLong();
 1777               if (n == Long.MIN_VALUE) {
 1778                   n = 0;      // corner case
 1779               } else {
 1780                   n = Math.abs(n);
 1781               }
 1782               return new File(dir, prefix + Long.toString(n) + suffix);
 1783           }