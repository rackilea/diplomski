#import "Client.h"

@implementation Client
@synthesize deviceID = _deviceID;
@synthesize nickName = _nickName;

- (BOOL)matches:(id<IClient>)client
{
    if (client != nil) {
        if (client == self)
            return YES;
        if ([client.deviceID isEqualTo:self.deviceID] && [client.nickName isEqualTo:self.nickName])
            return YES;
    }
    return NO;
}
@end