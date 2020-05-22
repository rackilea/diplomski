public class TurboCppCompiler implements CppCompiler {

    // .. private variables

    public TurboCppCompiler(TurboParser parser, TurboAssembler assembler, TurboLinker linker) {
        this.parser = parser;
        this.assembler = assembler;
        this.linker = linker;
    }

    public void compile(String sourceFile) {
        /* Compile the code Borland Cpp style using the subsystems Parser, Assembler, Linker */
    }
}