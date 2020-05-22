YourClass *arrObj=[YourClass new];//your target class where you wnat to check
NSString *propertyName=@"samllArray";//this is what you will check in class YourClass
if([arrObj respondsToSelector:NSSelectorFromString(propertyName)]){
    NSLog(@"yes, exists");
}
else{
    NSLog(@"no, it does not exists");
}