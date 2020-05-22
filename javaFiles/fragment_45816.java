public int getTotalSubscriptions()
        throws Exception
{
        GetSubscriberListRequest subscriberListRequest = factory.createGetSubscriberListRequest();
        Holder<ResultCodeStruct> result = new Holder<ResultCodeStruct>(factory.createResultCodeStruct());
        Holder<PaginatedInfo> paginatedInfo = new Holder<PaginatedInfo>(factory.createPaginatedInfo());
        Holder<Integer> totalSubsFound = new Holder<Integer>(new Integer(0));
        Holder<GetSubscriberListData> subscriberListData = new Holder<GetSubscriberListData>(factory.createGetSubscriberListData());

    subscriberListRequest.setMaxSubscribers(factory.createGetSubscriberListRequestMaxSubscribers(1));

    port.getSubscriberList(subscriberListRequest,
            result,
            paginatedInfo,
            totalSubsFound,
            subscriberListData);

    if (result.value.getResultCode() != CODE_SUCCESS)
    {
        throw new Exception("Failed call");
    }

    return totalSubsFound.value.intValue();
}