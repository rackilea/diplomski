input.stream().map(list -> {
    ArrayList<DateValue> padded = new ArrayList<>();

    Iterator<DateValue> iterator = list.iterator();
    DateValue next = iterator.next();

    for (LocalDate temp = minDate; !temp.isAfter(maxDate); temp = temp.plusDays(1))
    {
        if (next == null || next.getDate().isAfter(temp))
        {
            padded.add(new DateValue(temp, 0.0));
        }
        else
        {
            padded.add(next);
            next = iterator.hasNext() ? iterator.next() : null;
        }
    }

    return padded;
}).collect(Collectors.toList());