$ java -jar jmh-samples/target/benchmarks.jar -prof stack:help
Usage: -prof <profiler-name>:opt1=value1,value2;opt2=value3

Options accepted by org.openjdk.jmh.profile.StackProfiler:

  lines=<int>     Number of stack lines to save in each stack trace.
                  Larger values provide more insight into who is calling
                  the top stack method, as the expense of more stack
                  trace shapes to collect. (default: [1])