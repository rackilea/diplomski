sourceSets {
    acct {
        java {
            srcDirs = ["src"] // replaces default rather than adding another dir
            include "my/program/some/package/Acct.java"
        }
    }
}