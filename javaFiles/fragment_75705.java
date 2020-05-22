boolean test(String str){
try{
//String str = "B:10 S:5";
String[] arr = str.split(" ");//split to left and right of space = [B:10,S:5]
String[] bArr = arr[0].split(":");//split ...first colon = [B,10]
String[] sArr = arr[1].split(":");//... second colon = [S,5]

//need to use try/catch here in case the string is not an int value.
String labelB = bArr[0];
Integer b = Integer.parseInt(bArr[1]);
String labelS = sArr[0];
Integer s = Integer.parseInt(sArr[1]);
}catch( Exception e){return false;}
return true;
}