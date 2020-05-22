Date dateFrom = ...
Date dateTo = ...

String sql = "... where myDate >= ? and myDate <= ? "

preparedStatement.setDate(1, dateFrom);
preparedStatement.setDate(2, dateTo);