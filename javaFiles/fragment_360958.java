int size = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
            size += length;
            publishProgress(size*100/your_file_size_in_bytes);
        }