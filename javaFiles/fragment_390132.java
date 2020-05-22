Integer currentPrimeSquare = primeList.get(i)*primeList.get(i);
    if(currentPrimeSquare>numberTested) {
        //still not found a divider -- we found a prime
        primeList.add(numberTested);
        break;
    }