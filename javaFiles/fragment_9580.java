List<ChannelInfo> pairs = Arrays.asList(
            new ChannelInfo(15, "A"), new ChannelInfo(16, "B"), 
            new ChannelInfo(17, "C"), new ChannelInfo(20, "A"), 
            new ChannelInfo(22, "C"), new ChannelInfo(24, "B"), 
            new ChannelInfo(26, "C"), new ChannelInfo(27, "B"), 
            new ChannelInfo(28, "A"));

    Map<String, Double> map = pairs.stream()
            .collect(Collectors.groupingBy(ChannelInfo::getChannel, 
                       Collectors.collectingAndThen(Collectors.toList(),
                         list -> {
                            int size = list.size();
                            return IntStream.range(1, size)
                                .map(x -> (list.get(size - x).getTime() - list.get(size - x - 1).getTime()))
                                .average()
                                .orElse(0d);

                    })));

    System.out.println(map); // {A=6.5, B=5.5, C=4.5}