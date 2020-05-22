Comparator<? super Animal> animalComparator = (a, b) -> {
        StringTokenizer firstTokenizer = new StringTokenizer(a.getName(), " ");
        firstTokenizer.nextToken();
        StringTokenizer secondTokenizer = new StringTokenizer(b.getName(), " ");
        secondTokenizer.nextToken();
        return firstTokenizer.nextToken().compareTo(secondTokenizer.nextToken());
    };

    myList = myList.stream().sorted(animalComparator).collect(Collectors.toList());