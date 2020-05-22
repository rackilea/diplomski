column("Test Execution Status", Test::statusProperty).cellFormat {
    text = it.toString()
    if (it == TestStatus.PASS)
        this.tableRow.addClass(Style.pass)
    else if (it == TestStatus.FAIL)
        this.tableRow.addClass(Style.fail)
}