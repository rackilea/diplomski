String num2code (int n) {
    return (n > 0) ? num2code (n/10) + codes.get (n % 10) : "";
}

-> num2code (54170)
|  Expression value is: ":||::::|:|:::|:||::|:||:::"
|    assigned to temporary variable $4 of type String