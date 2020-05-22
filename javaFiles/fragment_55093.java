if (Build.VERSION_CODES.HONEYCOMB_MR1 >= Build.VERSION.SDK_INT) {
    // then you are on a device running android 3.1+ and it is
    // safe to make use of the new classes/methods
} else {
    // otherwise, you are running on a device running android 3.0
    // or lower. you should not make use of the new classes/methods.
}