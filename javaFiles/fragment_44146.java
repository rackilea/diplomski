public StringReference mirrorOf(String value) {
    validateVM();
    try {
        return (StringReference)JDWP.VirtualMachine.CreateString.
            process(vm, value).stringObject;
    } catch (JDWPException exc) {
        throw exc.toJDIException();
    }
}