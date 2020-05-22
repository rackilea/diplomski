public <M> List<M> insert(List<M> records) {
            if (records.isEmpty()) return records;
            M rec = records.get(0);

            List<? extends Record> actualRecords = (rec instanceof Record) ? 
                    (List<Record>)records : createMappedRecords(records, rec.getClass());

            connection.insertBulk(actualRecords);
            return records;
        }