@Benchmark
public String castMethod() {
    return type.cast(msg);
}

@Benchmark
@Fork(jvmArgs = {
        "-XX:+UnlockDiagnosticVMOptions",
        "-XX:DisableIntrinsic=_Class_cast,_isInstance",
})
public String castMethodNoIntrinsic() {
    return type.cast(msg);
}