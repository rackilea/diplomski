NSString *MyLocalizedString(NSString* key, NSString* comment)
{

static NSBundle* bundle = nil;
if (!bundle) {

    NSString *path_tmp = @"pathToBundle/JNILIB.bundle";

    NSBundle *libraryBundle = [NSBundle bundleWithPath:path_tmp];
    NSString *langID        = [[NSLocale preferredLanguages] objectAtIndex:0];

    NSLog(@"preferredLanguage: %@", langID);

    NSString *path          = [libraryBundle pathForResource:langID ofType:@"lproj"];

    NSLog(@"libraryBundle : %@", path);

    bundle                  = [[NSBundle bundleWithPath:path] retain];
}

return [bundle localizedStringForKey:key value:@"Can't be found!" table:@"Localized"];
}