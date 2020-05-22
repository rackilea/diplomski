void Main() {
    string a = "a";
    string b = "b";
    string alsoA = a;
    Swap(ref a, ref b);
    Console.WriteLine(a); // B
    Console.WriteLine(b); // A
    Console.WriteLine(alsoA); // A
}