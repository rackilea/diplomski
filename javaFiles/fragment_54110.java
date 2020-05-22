mappings.stream()                       
        .collect(Collectors.toMap(A::getId, m ->
                        {
                            boolean isB = m instanceof B;
                            return isB ? ((B) m).isVisible() : true;
                        }));