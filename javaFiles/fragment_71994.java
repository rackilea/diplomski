subscriber.create_datareader_with_profile(
    topic, "Keep_History_Library", "Keep_All_History_profile", 
    listener, StatusKind.STATUS_MASK_ALL);

publisher.create_datawriter_with_profile(
    topic, "Keep_History_Library", "Keep_All_History_profile", 
null, StatusKind.STATUS_MASK_NONE);