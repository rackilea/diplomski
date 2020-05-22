void Swap(ref string a, ref string b) {
    string c = b;
    b = a;
    a = c;
}
void main() {
    string a = "A";
    string b = "B";
    Swap(ref a, ref b);
    Console.WriteLine(a); // B
    Console.WriteLine(b); // A
}