CsvReader products = new CsvReader("CSV file path ");

        products.readHeaders();

        while (products.readRecord())
        {
            String productID = products.get("year");
            String productName = products.get("class");
            String supplierID = products.get("day");
            String categoryID = products.get("mm");

        }

        products.close();