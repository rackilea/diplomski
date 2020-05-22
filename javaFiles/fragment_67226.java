LocalDate minDate = input.stream()
                         .map(l -> l.get(0).getDate())
                         .min(Comparator.naturalOrder())
                         .get();
LocalDate maxDate = input.stream()
                         .map(l -> l.get(l.size() - 1).getDate())
                         .max(Comparator.naturalOrder())
                         .get();