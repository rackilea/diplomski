- (NSMutableArray *)getAllPropertyOfClass:(Class)aClass {
    NSMutableArray *mArray=[NSMutableArray new];
    unsigned int outCount;
    Ivar *ivars = class_copyIvarList([aClass class], &outCount); //class_copyPropertyList([aClass class], &outCount);

    for(unsigned int i = 0; i < outCount; i++) {
        Ivar ivar = ivars[i];
        const char *propName = ivar_getName(ivar);
        if(propName) {
            NSString *propertyName = [NSString stringWithUTF8String:propName];
            mArray[mArray.count]=propertyName;
        }
    }
    free(ivars);
    return mArray;
}