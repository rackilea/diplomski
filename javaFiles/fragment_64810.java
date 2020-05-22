String s[] ="J-549 J-628 J-379 J-073 J-980 vs J-548 J-034 J-127 J-625 J-667\\"
                    .replace("\\", "")
                    .replace("J-", "")
                    .replace(" vs ", " ")
                    .split(" ");
//System.out.println(s);
int[] id = new int[10];
for(int i=0; i<s.length; i++) {
    id[i] = Integer.valueOf(s[i]);
}
for(int i=0; i<id.length; i++) {
    System.out.println(id[i]);
}