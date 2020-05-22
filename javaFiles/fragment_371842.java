//.h
#import <Foundation/Foundation.h>
#import <objc/runtime.h>


@interface BeanUtils : NSObject

+(void)copyProperties:(id)src dest:(id)dest;

@end