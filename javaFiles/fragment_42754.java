jlink {

    mergedModule {
        requires "java.xml"
    }

    options = ['--strip-debug', '--compress', '2', '--no-header-files', '--no-man-pages']
    launcher {
        name = 'myapp'
    }
}