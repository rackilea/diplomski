BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
BufferedReader br1 = new BufferedReader(fr);
String str;
int r;
char ch;
int count = 0;
str = br.readLine();

while ((r = br1.read()) != -1) {
    ch = (char) r;
    if (ch == ' ') {
        count++;
    } else if (count == 3) {
        fw.write(" " + str + ' ');
        count = 0;
    } else {
        fw.write(ch);
    }
}