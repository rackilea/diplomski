MyEnumClass* FOO = nil; // This is the actual instance of FOO that will be shared by anyone who includes "Foo.h".  That's what the extern keyword accomplishes.

+ (void)initialize {
    if (!FOO) {
        FOO = [[MyEnumClass alloc] initWithStr:@"foo string" andInt:42];
    }
}