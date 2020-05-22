void foo() {
    var_ = 0;
    foo_helper();
}

void foo_helper() {
    if(var_ == 3)
        return;
    else
        var_++; foo_helper();
}