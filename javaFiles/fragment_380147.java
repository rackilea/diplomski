String str = "My phone 25\nValet 50\niPod 25";

String lines[] = str.split("\\r?\\n");

for(String line : lines){
    int index=line.trim().lastIndexOf(" ");
    String str1 = line.substring(0,index);
    System.out.println(str1);
    String str2 = line.substring(index+1);
    System.out.println(str2);
}