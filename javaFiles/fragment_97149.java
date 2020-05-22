NSMutableArray *arrFixedData=[[NSMutableArray alloc]initWithObjects:@"DCS",@"DCT",@"DCU",@"DAG",@"DAI",@"DAJ",@"DAK",@"DCG",@"DAQ",@"DCA",@"DCB",@"DCD",@"DCF",@"DCH",@"DBA",@"DBB",@"DBC",@"DBD",@"DAU",@"DCE",@"DAY",@"ZWA",@"ZWB",@"ZWC",@"ZWD",@"ZWE",@"ZWF", nil];
    NSMutableArray *arrDriverData=[[NSMutableArray alloc]initWithObjects:@"Customer Family Name",@"Customer Given Name",@"Name Suffix",@"Street Address 1",@"City",@"Jurisdction Code",@"Postal Code",@"Country Identification",@"Customer Id Number",@"Class",@"Restrictions",@"Endorsements",@"Document Discriminator",@"Vehicle Code",@"Expiration Date",@"Date Of Birth",@"Sex",@"Issue Date",@"Height",@"Weight",@"Eye Color",@"Control Number",@"Endorsements",@"Transaction Types",@"Under 18 Until",@"Under 21 Until",@"Revision Date", nil];


    NSMutableDictionary *dict=[[NSMutableDictionary alloc]init];
    for (int i=0; i<[arrFixedData count]; i++)
    {
        NSRange range = [message  rangeOfString: [arrFixedData objectAtIndex:i] options: NSCaseInsensitiveSearch];
        NSLog(@"found: %@", (range.location != NSNotFound) ? @"Yes" : @"No");
        if (range.location != NSNotFound)
        {
            NSString *temp=[message substringFromIndex:range.location+range.length];

            NSRange end = [temp rangeOfString:@"\n"];
            if (end.location != NSNotFound)
            {
                temp = [temp substringToIndex:end.location];
                temp =[temp stringByReplacingOccurrencesOfString:@"\n" withString:@""];
                temp=[temp stringByTrimmingCharactersInSet:[NSCharacterSet whitespaceAndNewlineCharacterSet]];

            }
            NSLog(@"temp data : %@",temp);
            [dict setObject:temp forKey:[arrDriverData objectAtIndex:i]];
        }
    }

    NSLog(@"Dictionary : %@",dict);