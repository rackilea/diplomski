NSString *msg = @"initChat_";
NSString *messageToSend  = [NSString stringWithFormat:@"%@", msg];
NSData *data = [self convertToJavaUTF8:messageToSend];

int dataLenght = [data length];

int num = [outputStream write:(const uint8_t *)[data bytes] maxLength:dataLenght];


if (-1 == num) {
    NSLog(@"Error writing to stream %@: %@", outputStream, [outputStream streamError]);
}else{
    NSLog(@"Wrote %i bytes to stream %@.", num, outputStream);
}