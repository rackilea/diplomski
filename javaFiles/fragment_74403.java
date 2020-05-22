public Process exec(        
        String programName,
        Integer maxSize,
        Integer maxSizeO,
        String[] inFiles,
        String outFile) throws IOException {


    ProcessBuilder pb = new ProcessBuilder();

    List<String> cmd = new ArrayList<String>();
    cmd.add(programName);
    if (maxSize != null) {
        cmd.add("-a");
        cmd.add("" + maxSize);
    }
    if (maxSizeO != null) {
        cmd.add("-o");
        cmd.add("" + maxSizeO);
    }
    if (inFiles != null) {
        cmd.addAll(Arrays.asList(inFiles));
    }
    if (outFile != null) {
        cmd.add(outFile);
    }

    Process p = pb.start();

    return p;
}