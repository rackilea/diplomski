@Override
public int compareTo(MyClass m) {
    int compareValue = value - m.value;
    if(compareValue == 0)
        return index - m.index;
    return compareValue;
}