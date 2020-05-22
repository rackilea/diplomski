Map<Integer, Integer> map = bids.stream().collect(
    groupingBy(
            {bid -> bid.bidderUserId},
            collectingAndThen(
                    mapping({bid -> bid.auctionId}, toSet()),
                    {set -> set.size()})));