String[] result = StringUtils.split(testString,"$");
System.out.println("Length is "+ result.length); // 2
int i=1;
for(String str : result) {
    System.out.println("Str"+(i++)+" "+str);
}