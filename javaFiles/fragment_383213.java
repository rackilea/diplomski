public synchronized void write(K key, V value) throws IOException {

        boolean nullKey = key == null || key instanceof NullWritable;
        boolean nullValue = value == null || value instanceof NullWritable;
        if (nullKey && nullValue) {
            return;
        }

        if (!nullKey) {
            // if we've written data before, append a new line
            if (dataWritten) {
                out.write(newline);
            }

            // write out the key and separator
            writeObject(key);
            out.write(keyValueSeparator);
        } else if (!nullValue) {
            // write out the value delimiter
            out.write(valueDelimiter);
        }

        // write out the value
        writeObject(value);

        // track that we've written some data
        dataWritten = true;
    }

    public synchronized void close(Reporter reporter) throws IOException {
        // if we've written out any data, append a closing newline
        if (dataWritten) {
            out.write(newline);
        }

        out.close();
    }