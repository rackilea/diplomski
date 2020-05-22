#import <Foundation/Foundation.h>
#import <CommonCrypto/CommonHMAC.h>

NSData *hmacForKeyAndData(NSString *key, NSString *data)
{
    const char *cKey  = [key cStringUsingEncoding:NSASCIIStringEncoding];
    const char *cData = [data cStringUsingEncoding:NSASCIIStringEncoding];
    unsigned char cHMAC[CC_SHA256_DIGEST_LENGTH];
    CCHmac(kCCHmacAlgSHA256, cKey, strlen(cKey), cData, strlen(cData), cHMAC);
    return [[NSData alloc] initWithBytes:cHMAC length:sizeof(cHMAC)];
}

int main (int argc, const char * argv[])
{
    @autoreleasepool {
        // Compare to http://en.wikipedia.org/wiki/HMAC#Examples_of_HMAC_.28MD5.2C_SHA1.2C_SHA256_.29
        NSLog(@"empty hmac = %@", hmacForKeyAndData(@"", @""));
        NSLog(@"test hmac = %@", hmacForKeyAndData(@"YARJSuwP5Oo6/r47LczzWjUx/T8ioAJpUK2YfdI/ZshlTUP8q4ujEVjC0seEUAAtS6YEE1Veghz+IDbNQb+2KQ==", @"id=456|time=19:10|nonce=8"));
    }
    return 0;
}