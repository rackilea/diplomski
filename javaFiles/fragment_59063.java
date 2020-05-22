brFileToCopyFrom.mark(1024); // number of characters to be read while preserving the mark

while ((lineSource = brSource.readLine()) != null) {

        brFileToCopyFrom.reset();

        while ((lineToCopy = brFileToCopyFrom.readLine()) != null) {
            ...
        }

    }
}