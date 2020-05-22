List<Curriculum> curriculumList = IntStream.range(0, jsonarray.length()).parallel()
            .mapToObj(i -> {
                JSONObject jsonobject = jsonarray.getJSONObject(i);

                // fetch the various parts...

                return new Curriculum(course, credits, courseType, semesterCount, prereqCourseList, prereqChainCourseList, alternateCourse, batch, major);
            }).collect(Collectors.toList());