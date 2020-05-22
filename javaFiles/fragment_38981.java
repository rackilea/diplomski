public static CppCompiler createCppCompiler(CompilerType type) {
    switch (type) {
        case TURBO:
            return new TurboCppCompiler(new TurboParser(), new TurboAssembler(), new TurboLinker());
        case BORLAND:
            return new BorlandCppCompiler(new BorlandParser(), new BorlandAssembler(), new BorlandLinker());
        case GCC:
            return new GccCppCompiler(new GccParser(), new GccAssembler(), new GccLinker());
    }
    throw new AssertionError("unknown compiler type:" + type);
}