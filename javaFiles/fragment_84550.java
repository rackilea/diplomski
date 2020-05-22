Set<String> first = new HashSet<>();
Set<String> second = new HashSet<>();
for (HeaderAndBodyTestcase tc : tcs) {
    if (! first.contains(tc.getSecondInputFile()) && 
            ! second.contains(tc.getFirstInputFile())) {
        first.add(tc.getFirstInputFile());
        second.add(tc.getSecondInputFile());
        System.out.println(tc); // or add to result list
    }
}