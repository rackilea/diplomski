Function<School, String> getSchoolsPrimaryChairInitials = school -> school.getChairs()
                .stream()
                .filter(Chair::isPrimaryChair)
                .findFirst()
                .get()//consider possibility of not having primary chair
                .getInitials();

        Map<String, Set<School>> schoolsByChair = schools
                .stream()
                .collect(Collectors.groupingBy(getSchoolsPrimaryChairInitials, Collectors.toSet()));

        Map<String, Set<School>> schoolsByShortName = schools
                .stream()
                .collect(Collectors.groupingBy(School::getShortName, Collectors.toSet()));