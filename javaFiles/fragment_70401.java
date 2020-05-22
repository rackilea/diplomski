NSError *error = nil;
NSRegularExpression *expression = [NSRegularExpression regularExpressionWithPattern:@"[aZ]" options:0 error:&error];
if (error) {
    // Do something when an error occurs
}
NSString *candidate = @"abc";
BOOL lookingAt = [expression numberOfMatchesInString:candidate options:NSMatchingAnchored range:NSMakeRange(0, candidate.length)] > 0;