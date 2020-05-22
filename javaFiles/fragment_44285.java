import org.gradle.logging.internal.OutputEvent
import org.gradle.logging.internal.OutputEventListener

        task("javadocCheck",type:Javadoc){
            // regular javadoc task configuration

            def outputEvents = []
            def listener=new OutputEventListener(){
                    void onOutput(OutputEvent event){
                        outputEvents << event
                    }
                };
            doFirst {
                getLogging().addOutputEventListener(listener)
            }
            doLast {
                getLogging().removeOutputEventListener(listener)
                outputEvents.each { e ->
                    if(e.toString() =~ " warning: "){
                        throw new GradleException("You have some javadoc warnings, please fix them!");
                    }
                }
            }
        }