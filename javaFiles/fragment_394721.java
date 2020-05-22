for(Object[] row: resultSet) {
        MyTable mt = new MyTable();
        if(resultSet instanceof BigDecimal) {
            mt.setIdCol((BigDecimal)row[0].longValue());
        } else if (resultSet instanceof String){
            ....
        }
    }