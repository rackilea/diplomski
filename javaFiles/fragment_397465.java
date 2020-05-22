Map<Integer, Integer> map = bids.stream().collect(
    groupingBy(
            {it.&getBidderUserId()},
            collectingAndThen(
                    mapping({it.&getAuctionId()}, toSet()),
                    {it.&size()})));