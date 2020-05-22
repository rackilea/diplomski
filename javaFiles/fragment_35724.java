public static void eliminateDups(final String srcfile, final String dstfile)
    throws IOException
{
    final StringBuilder sb = new StringBuilder();
    final Set<String> seen = new HashSet<>();
    final Charset charset = StandardCharsets.UTF_8;

    final Path src = Paths.get(srcfile);
    final Path dst = Paths.get(dstfile);

    try (
        final BufferedReader reader = Files.newBufferedReader(src, charset);
        final BufferedWriter writer = Files.newBufferedWriter(dst, charset,
            StandardOpenOption.TRUNCATE_EXISTING);
    ) {
        String line1, line2;
        while ((line1 = reader.readLine()) != null) {
            line2 = reader.readLine();
            sb.setLength(0);
            if (!seen.add(sb.append(line1).append(line2).toString()))
                continue;
            writer.write(line1);
            writer.newLine();
            writer.write(line2);
            writer.newLine();
        }
    }
}