task doItSerial << {
    ant.exec(executable: "${projectDir}/wait.sh") {
        arg(value: 10)
        arg(value: "TRACER A")
    }
    ant.exec(executable: "${projectDir}/wait.sh") {
        arg(value: 10)
        arg(value: "TRACER B")
    }
}

task doItParallel << {
    ant.parallel {
        ant.exec(executable: "${projectDir}/wait.sh") {
            arg(value: 10)
            arg(value: "TRACER A")
        }
        ant.exec(executable: "${projectDir}/wait.sh") {
            arg(value: 10)
            arg(value: "TRACER B")
        }
    }
}