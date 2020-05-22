Process process = Runtime.getRuntime().exec(new String[] {"ps", "-ef", "|", "grep", "java"});

final char[] buffer = new char[0x10000];
StringBuilder out = new StringBuilder();
Reader in = new InputStreamReader(process.getInputStream(), "UTF-8");
int read;
do {
    read = in.read(buffer, 0, buffer.length);
    if (read>0) {
        out.append(buffer, 0, read);
    }
} while (read>=0);
process.destroy();

System.out.println(out);