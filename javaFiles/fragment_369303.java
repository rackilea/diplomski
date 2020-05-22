@Query("SELECT f FROM Foo f ORDER BY CASE
WHEN f.state = com.package.State.ONE THEN f.deadlineOne
WHEN f.state = com.package.State.TWO THEN f.deadlineTwo
WHEN f.state = com.package.State.THREE THEN f.deadlineThree
ELSE f.deadlineOne END")
Page<Foo> findSortedByNextDeadline(Pageable pageable);