String datetime = "01/03/2013 09:00";

String[] sParts = datetime.split("[/:\\s+]");
int[] iParts = new int[sParts.length];

for(int i = 0; i < sParts.length; i++)
    iParts[i] = Integer.parseInt(sParts[i]);

System.out.println(Arrays.toString(iParts));