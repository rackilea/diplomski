#import <Foundation/Foundation.h>
#import <CommonCrypto/CommonCrypto.h>

@interface AES : NSObject 

+ (NSData *)Encrypt:(NSString *)data WithKey:(NSString *)key;
+ (NSString *)Decrypt:(NSData *)data WithKey:(NSString *)key;

+ (NSData *)AESOperation:(CCOperation)operation OnData:(NSData *)data key:(NSString *)key;

@end