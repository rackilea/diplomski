private final String uri = "jpa://TotoPollerRoute?consumeDelete=false"
    + "&consumeLockEntity=true"
    + "&consumer.SkipLockedEntity=true"
    + "&maximumResults=10"
    + "&sharedEntityManager=true"
    + "&joinTransaction=false"
    + "&consumer.query=select tt from Toto tt where tt.key = 1";