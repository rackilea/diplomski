InputStream in = new SequenceInputStream(
                        // start doc
                        new ByteArrayInputStream("<root>".getBytes()),
                        new SequenceInputStream(
                           new FileInputStream("envelopes.txt"),
                           // end doc
                           new ByteArrayInputStream("</root>".getBytes())));