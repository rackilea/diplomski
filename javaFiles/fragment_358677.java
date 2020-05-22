Ordering<X> primary = Ordering.natural().onResultOf(stringValueSortFunction);
Ordering<X> secondary = Ordering.natural()
                              .onResultOf(dateValueSortFunction)
                              .reverse();
Ordering<X> compound = primary.compound(secondary);

List<X> sortedList = compound.immutableSortedCopy(lotsOfX);