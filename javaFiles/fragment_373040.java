import groovy.transform.Canonical
import org.codehaus.groovy.control.CompilerConfiguration

@Canonical
class ScriptState {
    String data
}

abstract class MyScript extends Script {
    void setData(String data) {
        binding.state.data = data
    }
}

def state = new ScriptState()
def cc = new CompilerConfiguration(scriptBaseClass: MyScript.class.name)

def shell = new GroovyShell(MyScript.classLoader, new Binding(state: state), cc)

shell.evaluate('println "Running script"; setData "The Data"')

assert state.data == 'The Data'

println state