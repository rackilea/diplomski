DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

// 2018-08-03 03:50:17
LocalDateTime.now().format(formatter);

// 2018-09-03 03:50:17
LocalDateTime.now().plusMonths(1).format(formatter);