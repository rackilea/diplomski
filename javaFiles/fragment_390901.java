String[] patterns = {"yyyy-MM-dd HH:mm", "yyyy-MM-dd HH"};
String date = "2018-02-02 11:50";
boolean check = Arrays.asList(patterns).stream()
        .anyMatch(pattern -> {
            try {
                LocalDateTime.parse(date, DateTimeFormatter.ofPattern(pattern));
                System.out.println("Correct");
                return true;
            } catch (Exception e) {
                System.out.println("Not Correct");
                return false;
            }
        });