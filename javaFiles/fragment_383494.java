flowFile = session.write(flowFile, new StreamCallback() {
            @Override
            public void process(InputStream in, OutputStream out) throws IOException {
                try (InputStreamReader inReader = new InputStreamReader(in);
                    BufferedReader reader = new BufferedReader(inReader);
                     OutputStreamWriter outWriter = new OutputStreamWriter(out);
                     BufferedWriter writer = new BufferedWriter(outWriter)) {

                    String line = reader.readLine();
                    while (line != null) {
                        line = process(line);

                        writer.write(line);
                        writer.newLine();

                        line = reader.readLine();
                    }
                }
            }
        });