- (NSString *) descramble:(NSString*) input{
   char *ret = [input UTF8String];
   int offset = (-1 * [scrambBase20 count]);
   for(int i=0;i<[input length];i++){
        if(i% [scrambBase20 count] == 0){
            offset+= [scrambBase20 count];
        }
        ret[scrambBase20[i%[scrambBase20 count]+offset] = (char) ((Byte) [input characterAtIndex:i]^0x45);
    }
    NSString *realRet = [[NSString alloc] initWithUTF8String:ret];
    [realRet stringByTrimmingCharactersInSet:[NSCharacterSet whitespaceCharacterSet]];
    return realRet;
}