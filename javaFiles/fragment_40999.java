Map<String, BigInteger> map =
    fromDB().stream()
            .collect(Collectors.toMap(
                o -> (String) o[0],
                o -> (BigInteger) o[1],
                (b1, b2) -> b2
            ));