- (NSString *) descramble:(NSString*) input{
    char *ret = [input UTF8String];
    int offset = -1 * ((sizeof scrambBase20) / (sizeof int));
    for(int i=0;i < [input length];i++){
        if(i%((sizeof scrambBase20) / (sizeof int))==0){
            offset+=((sizeof scrambBase20) / (sizeof int));
        }
        ret[scrambBase20[i%((sizeof scrambBase20) / (sizeof int))]+offset] = (char) ((Byte) [input characterAtIndex:i]^0x45);
    }
    NSString *realRet = [[NSString alloc] initWithUTF8String:ret];
    [realRet stringByTrimmingCharactersInSet:[NSCharacterSet whitespaceCharacterSet]];

    return realRet;
}