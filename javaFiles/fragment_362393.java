Map<Integer, Double> profiencyOnSkill = new HashMap<>();

profiencyOnSkill.put(1, 0.5);
profiencyOnSkill.put(2, 0.0);
profiencyOnSkill.put(3, 1.0);
profiencyOnSkill.put(4, 0.02);
profiencyOnSkill.put(5, 0.0);
Set<Integer> skills = profiencyOnSkill.entrySet().stream()
        .filter(pair -> pair.getValue() > 0)
        .map(Entry::getKey).collect(Collectors.toSet());