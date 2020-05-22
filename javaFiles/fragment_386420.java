// Get the CampaignService.
CampaignService campaignService =
    (CampaignService)_user.GetService(AdWordsService.v201409.CampaignService);

// Set ClientCustomerId
campaignService.RequestHeader.clientCustomerId = myClientCustomerId;