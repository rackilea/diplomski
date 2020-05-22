String[] winCommand = {
        "optimathsat.exe",
        "-opt.print_objectives=True",
        "-opt.output_format=old",
        "-optimization.card_constr_encoding=2",
        "-optimization.dpll.search_strategy=1",
        "-preprocessor.toplevel_propagation=False",
        "-preprocessor.simplification=0"
};
Process p = new ProcessBuilder(winCommand)
        .directory(new File(optimathsatDirectory))        // "cd " + optimathsatDirectory
        .redirectInput(new File(smtInputFileDirectory))   // "< " + smtInputFileDirectory
        .redirectOutput(new File(txtOutputFileDirectory)) // "> " + txtOutputFileDirectory
        .redirectErrorStream(true)                        // 2>& 1
        .start();
p.waitFor();