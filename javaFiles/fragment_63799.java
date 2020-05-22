public Collection<String> doctorsByNumPatients() {
    return doctors.values()
            .stream()
            .sorted(Comparator.comparing((Doctor d) -> d.getPatients().size()).reversed())
            .map(d -> String.format("%3d %s", d.getPatients().size(), d.toString()))
            .collect(Collectors.toList());
}