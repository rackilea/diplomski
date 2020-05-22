HM2.entrySet()
   .forEach(entry -> HM1.compute(
            entry.getKey(),
            (key, value) -> value == null ? 
                            entry.getValue() : 
                            entry.getValue() + value));