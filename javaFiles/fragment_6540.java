- (NSData*) convertToJavaUTF8 : (NSString*) str {
NSUInteger len = [str lengthOfBytesUsingEncoding:NSUTF8StringEncoding];
Byte buffer[2];    
buffer[0] = (0xff & (len >> 8));
buffer[1] = (0xff & len);
NSMutableData *outData = [NSMutableData dataWithCapacity:2];
[outData appendBytes:buffer length:2];        
[outData appendData:[str dataUsingEncoding:NSUTF8StringEncoding]];
return outData;}