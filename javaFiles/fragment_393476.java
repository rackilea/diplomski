AWSCognitoCredentialsProvider* credentialsProvider = [AWSCognitoCredentialsProvider
                                                      credentialsWithRegionType:AWSRegionUSEast1
                                                      accountId:@"xxxxxxxxxxx"
                                                      identityPoolId:@"xxxxxxxxxxx"
                                                      unauthRoleArn:@"arn:aws:iam::xxxxxxxxxxx"
                                                      authRoleArn:nil];

AWSServiceConfiguration* configuration = [AWSServiceConfiguration configurationWithRegion:AWSRegionUSWest2
                                                                      credentialsProvider:credentialsProvider];

[AWSServiceManager defaultServiceManager].defaultServiceConfiguration = configuration;