public int _ID;

public static void swap(NormalClass[] arr) {
    NormalClass temp = arr[0];
    arr[0] = arr[1];
    arr[1] = temp;
}

@Override
public String toString() {
    return String.valueOf(this._ID);
}

NormalClass(int __id) {
    this._ID = __id;
}

public static void main(String[] args) {
    NormalClass[] arr = new NormalClass[] { new NormalClass(1235),
            new NormalClass(5468) };
    System.out.println("Before: 1st Object -->");
    System.out.println(arr[0]);
    System.out.println("Before: 2nd Object -->");
    System.out.println(arr[1]);

    NormalClass.swap(arr);

    System.out.println("After: 1st Object -->");
    System.out.println(arr[0]);
    System.out.println("After: 2nd Object -->");
    System.out.println(arr[1]);
}