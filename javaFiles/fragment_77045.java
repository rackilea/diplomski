public static MyCompositeObjects createWithCopy(MyObjects[] values) {
    return new MyCompositeObjects(Arrays.copyOf(values, values.length));
}

public static MyCompositeObjects createWithoutCopy(MyObjects... values) {
    return new MyCompositeObjects(values);
}

private MyCompositeObjects(MyObjects[] values) {
    this.objects = values;
}