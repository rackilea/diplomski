task versionTxt()  {
    doLast {
        new File("$projectDir/version.txt").text = """
#!/usr/bin/java -jar
#...
"""
    }
}