#import "AES.h"

@implementation AES

+ (NSData *)Encrypt:(NSString *)data WithKey:(NSString *)key {
    return [self AESOperation:kCCEncrypt OnData:[data dataUsingEncoding:NSUTF8StringEncoding] key:key];
}
+ (NSString *)Decrypt:(NSData *)data WithKey:(NSString *)key {
    return [[NSString alloc] initWithData:[self AESOperation:kCCDecrypt OnData:data key:key] encoding:NSUTF8StringEncoding];
}

+ (NSData *)AESOperation:(CCOperation)operation OnData:(NSData *)data key:(NSString *)key {
    char keyPtr[kCCKeySizeAES128];
    bzero(keyPtr, sizeof(keyPtr));
    [key getCString:keyPtr maxLength:sizeof(keyPtr) encoding:NSUTF8StringEncoding];

    NSUInteger dataLength = [data length];
    size_t bufferSize = dataLength + kCCBlockSizeAES128;
    void *buffer = malloc(bufferSize);

    size_t numBytesEncrypted = 0;
    CCCryptorStatus cryptStatus = CCCrypt(operation,
                                          kCCAlgorithmAES128,
                                          kCCOptionPKCS7Padding,
                                          keyPtr,
                                          kCCBlockSizeAES128,
                                          keyPtr,
                                          [data bytes],
                                          dataLength,
                                          buffer,
                                          bufferSize,
                                          &numBytesEncrypted);
    if (cryptStatus == kCCSuccess) {
        return [NSData dataWithBytesNoCopy:buffer length:numBytesEncrypted];
    }

    free(buffer);
    return nil;
}

@end