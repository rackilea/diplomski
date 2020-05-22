filterValue.ifPresentOrElse(value -> {
    if(value){
        method1();
    } else {
        method2();
    }
}, () -> method3());