List thirdPartyLibs = ['org.hibernate:hibernate:3.0.5@jar',
                       'somegroup:someorg:1.0@jar']

configurations.all {
    resolutionStrategy {
        force thirdPartyLibs
    }
}

dependencies {
    compile thirdPartyLibs
}