while ((lineSource = brSource.readLine()) != null) {

        BufferedReader brFileToCopyFrom = new BufferedReader(new FileReader(fileToCopyFrom));

        while ((lineToCopy = brFileToCopyFrom.readLine()) != null) {
            ...
        }

    }
}