fee = new BigDecimal(fees
            .stream()
            .filter(p -> p.getTodate().isAfter(LocalDateTime.now()))
            .filter(p -> p.getFromdate().isBefore(LocalDateTime.now()))
            .filter(p -> p.getId().equals(id))
            .map(p -> p.getFee())
            .findFirst()
            .orElse(/*some default value*/));