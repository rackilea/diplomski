// type mirror of MyHandler goes here
TypeMirror concrete = ...

// your base type goes here. Real code should cache it
TypeMirror base = types.getDeclaredType(el.getTypeElement("com.example.MyBase"));

// boom
TypeMirror arg = typeHelper.getTypeArg(concrete, base, 1);