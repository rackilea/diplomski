toSimpleName(String inp):
    switch (inp) {
        case "StringAttribute"  : "String"
        case "IntegerAttribute" : "int"
        // ...more cases here...
        default                 : inp
    }
;