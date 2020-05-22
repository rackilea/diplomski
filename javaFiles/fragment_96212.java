//Those IPs and Maks were provided by the domain
    String[] ipsAndMasks = { "AAA.BBB.CCC.DDD/26",
                         "EEE.BBB.CCC.DDD/24",
                 "FFF.BBB.CCC.DDD/29",
                 "GGG.BBB.CCC.DDD/22"};

    Collection<SubnetInfo> subnets = new ArrayList<SubnetInfo>();
    for (String ipAndMask : ipsAndMasks) {
        subnets.add(new SubnetUtils(ipAndMask).getInfo());
    }

    boolean requestIsComingFromTheCorrectDomain = false;
    String ipAddress = request.getRemoteAddr();
    for (SubnetInfo subnet : subnets) {
        if (subnet.isInRange(ipAddress)) {
            requestIsComingFromTheCorrectDomain = true;
            break;
        }
    }