public static void func1(Class1... t) {
    Class2[] arr = new Class2[t.length];
    for (int i = 0; i < t.length; i++)
        arr[i] = transform(t[i]);
    func2(arr);
}