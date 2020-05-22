@BindingAdapter("myAttrValue")
public static void setMyAttr(MyInnerView myInnerView, int value) {
    switch (value) {
        case 0:
            myInnerView.foo();
            break;
        default:
            myInnerView.bar();
    }
}