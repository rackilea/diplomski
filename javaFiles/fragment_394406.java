- (int)javaHashCode
{
    int h = 0;

    for (int i = 0; i < (int)self.length; i++) {
        h = (31 * h) + [self characterAtIndex:i];
    }

    return h;
}