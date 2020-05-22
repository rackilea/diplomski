task issueTest(type: Test) {
    // This task belongs to Verification task group.
    group = 'Verification'

    // Set Spock configuration file when running
    // this test task.
    systemProperty 'spock.issues', 'Issue4'
}