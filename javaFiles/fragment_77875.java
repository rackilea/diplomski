- (int)getRank:(NSString *passedString) {
    if([passedString isEqualToString:@"randomcard"]){
        return YES;
    } else {
        return NO;
    }
}