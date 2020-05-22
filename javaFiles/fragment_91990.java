String csvFilePath = args[0];
BufferedReader br = null;
String line = "";
String cvsSplitBy = ",";

HashTable chainedHashTable = new ChainedHashTable(100);

try {
        br = new BufferedReader(new FileReader(csvFilePath));
        while ((line = br.readLine()) != null) {

                // use comma as separator
            String[] cityRow = line.split(cvsSplitBy);

            String cityName = cityRow[0];
            Double latitude = Double.parseDouble(cityRow[1]);
            Double longitude = Double.parseDouble(cityRow[2]);
            Coordinate coordinate = new Cordinate(latitude, longitude);

            chainedHashTable.insert(cityName, coordinate);

        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (NumberFormateException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


class Coordinate {
    double latitude;
    double longitude;

    Coordinate (double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Other setters and getters
}