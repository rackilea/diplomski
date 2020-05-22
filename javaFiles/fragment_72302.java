val filtersParser = {
    import complete.DefaultParsers._
    (token(Space) ~> token(StringBasic, "<classFilter>")) ~
        (token(Space) ~> token(StringBasic, "<methodFilter>"))
}

lazy val testFiltered = inputKey[Unit]("runs test methods matching *<methodFilter>* within classes matching *<classFilter>*")

testFiltered.in(Test) := Def.inputTaskDyn {
    val (classFilter, methodFilter) = filtersParser.parsed
    runTestsFiltered(classFilter, methodFilter)
}.evaluated

def runTestsFiltered(classFilter: String, methodFilter: String) = Def.taskDyn {
    (testOnly in Test).toTask(s" *$classFilter* -- --tests *$methodFilter*")
}