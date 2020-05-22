void GetValue(Object o){
    if(o instanceof MyEnumerateClass.Enum1) {
        switch((MyEnumerateClass.Enum1) o){
        case enum1value1: ...
        }
    } else if (o instanceof MyEnumerateClass.Enum2) {
        switch((MyEnumerateClass.Enum2) o){
        case enum2value1: ...
        }
    }
}