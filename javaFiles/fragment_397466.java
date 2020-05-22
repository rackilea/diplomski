Map<Integer, Integer> map = bids.stream().collect(
    groupingBy(
            {it.bidderUserId},
            collectingAndThen(
                    mapping({it.auctionId}, toSet()),
                    {it.size()})));