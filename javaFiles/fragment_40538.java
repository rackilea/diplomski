while ((inputLine = in.readLine()) != null) {  
    StockLine line = parseStockLine(inputLine);
    stmt.setBigDecimal(1, line.getPrice());
    stmt.setBigDecimal(2, line.getHigh());
    stmt.setBigDecimal(3, line.getLow());
    stmt.setString(4, line.getName());
    stmt.addBatch();
}
stmt.executeBatch();