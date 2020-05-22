package com.dmercer

import org.codehaus.janino.SimpleCompiler;
import org.codehaus.janino.util.Benchmark

fun main(args: Array<String>) {
    val sourceString = """
package com.dmercer;

public class B implements BasicInterface {
    @Override
    public void runMethod() {
        System.out.println("Hello from compiled method");
    }
}
    """.trimIndent()

    val compiler = SimpleCompiler()
    compiler.cook(sourceString)
    val classLoader = compiler.classLoader
    val compiledClass = classLoader.loadClass("com.dmercer.B")// as IDBMethod
    val classInstance = compiledClass.newInstance() as BasicInterface 
    classInstance.runMethod()

}