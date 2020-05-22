lazy val testFiltered = inputKey[Unit]("runs test methods matching *<methodFilter>* within classes matching *<classFilter>*")

testFiltered.in(Test) := Def.inputTaskDyn {
    val (classFilter, methodFilter) = filtersParser.parsed
    runTestsFiltered(classFilter, methodFilter)
}.evaluated