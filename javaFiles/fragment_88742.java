interface ScienceStudent {
    String getClassroomId();
}
interface MathStudent {
    String getId();
}

Set<ScienceStudent> filter(
        Collection<MathStudent> mathStudents,
        Map<String, ScienceStudent> scienceStudents,
        Set<ScienceStudent> exclusionStudents,
        List<String> classRoomList) {

    return mathStudents.stream()
            .map(s -> scienceStudents.get(s.getId()))
            .filter(ss -> classRoomList.contains(ss.getClassroomId()))
            .filter(ss -> !exclusionStudents.contains(ss))
            .limit(5)
            .collect(Collectors.toSet());

}