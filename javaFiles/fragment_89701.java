ExecutorService executor = Executors.newFixedThreadPool(10);

// start many calls running in parallel
List<Future<Curriculum>> futures = IntStream.range(0, jsonarray.length())
        .mapToObj(i -> executor.submit(() -> {
                JSONObject jsonobject = jsonarray.getJSONObject(i);

                // fetch the various parts...

                return new Curriculum(course, credits, courseType, semesterCount, prereqCourseList, prereqChainCourseList, alternateCourse, batch, major);
            })).collect(Collectors.toList());

executor.shutdown();

List<Curriculum> curriculumList = new ArrayList<>();
for (Future<Curriculum> future : futures) {
    curriculumList.add(future.get());
}