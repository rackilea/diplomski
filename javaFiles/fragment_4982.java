String[] array = new String[]{"a,b,c", "1,2,3", "x,y,z"};

String[][] twoDim = new String[array.length][];

for (int i = 0; i < twoDim.length; i++)
    twoDim[i] = array[i].split(",");

System.out.println(Arrays.deepToString(twoDim));