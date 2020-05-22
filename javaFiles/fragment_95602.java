String smallestCity;
if (city1.compareTo(city2) < 0 && city1.compareTo(city3) < 0) {
    smallestCity = city1;
} else if (city2.compareTo(city1) < 0 && city2.compareTo(city3) < 0) {
    smallestCity = city2;
} else if (city3.compareTo(city1) < 0 && city3.compareTo(city2) < 0) {
    smallestCity = city3;
} else {
    throw new AssertionError("There is no strict order!");
}

String biggestCity;
if (city1.compareTo(city2) > 0 && city1.compareTo(city3) > 0) {
    biggestCity = city1;
} else if (city2.compareTo(city1) > 0 && city2.compareTo(city3) > 0) {
    biggestCity = city2;
} else if (city3.compareTo(city1) > 0 && city3.compareTo(city2) > 0) {
    biggestCity = city3;
} else {
    throw new AssertionError("There is no strict order!");
}

String middleCity;
if (city1.compareTo(smallestCity) > 0 && city1.compareTo(biggestCity) < 0) {
    middleCity = city1;
} else if (city2.compareTo(smallestCity) > 0 && city2.compareTo(biggestCity) < 0) {
    middleCity = city2;
} else if (city3.compareTo(smallestCity) > 0 && city3.compareTo(biggestCity) < 0) {
    middleCity = city3;
} else {
    throw new AssertionError("There is no strict order!");
}