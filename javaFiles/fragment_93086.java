BufferedReader read = new BufferedReader(
        new InputStreamReader(getAssets().open(name)));
BufferedReader count = new BufferedReader(
        new InputStreamReader(getAssets().open(name)));

String line;
String str = "";

while((line=count.readLine())!=null)

{
    str += read.readLine() + "\n";

}