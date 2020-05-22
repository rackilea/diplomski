static NSString * const kShowIntroductionKey = @"ShowIntroductionKey";

- (void)showOnFirstLaunch
{
    NSUserDefaults *userDefaults = [NSUserDefaults standardUserDefaults];
    BOOL wasIntroductionShowed = [userDefaults boolForKey:kShowIntroductionKey];

    if (!wasIntroductionShowed){

        // Show your screen here!

        [userDefaults setBool:YES forKey:kShowIntroductionKey];
        [userDefaults synchronize];
    }
}