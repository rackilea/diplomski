boolean distance(int a, int b) {
return Math.sqrt(Math.pow(Color.red(a) - Color.red(b), 2) + Math.pow(Color.blue(a) - Color.blue(b), 2) + Math.pow(Color.green(a) - Color.green(b), 2));
}
....
int reference = Color.RED;
if (distance(reference, pixels[i]) < 10) {
//pixel accepted
}