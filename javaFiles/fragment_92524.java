String[] result = "---4--5-67--8-9---".split("-+");
int i;
for (i = 0; i < result.length; i++) {
    if (result[i].length() > 0) {
        System.out.println(result[i]);
    }
}