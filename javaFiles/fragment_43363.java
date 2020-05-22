public class ProcessorNoProcess extends Processor {

    @Override protected List internalProcess(List input) { 
       // do nothing
       return input;
    }
}