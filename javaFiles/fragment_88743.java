return mathStudents.stream().filter(Objects::nonNull) // math students could be null
            .map(MathStudent::getId).filter(Objects::nonNull) // their id could be null
            .map(scienceStudents::get).filter(Objects::nonNull) // and the mapped science student
            .filter(ss -> classRoomList.contains(ss.getClassroomId()))
            .filter(ss -> !exclusionStudents.contains(ss))
            .limit(5)
            .collect(Collectors.toSet());