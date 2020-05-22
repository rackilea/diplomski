public class MultiThreadSimpleDateFormatClient {    
    public static void main(String[] args) {
        HandleDate handleDate = new HandleDate();
        Random random = new Random();
        Set<String> randomStrs = new HashSet<>();
        Thread thread1 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread2 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread3 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread4 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread5 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread6 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread7 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread8 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread9 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });
        Thread thread10 = new Thread(() -> {
            while (true) {
                int partOfYear = random.nextInt(10);
                handleDate.verifyNotThreadSafe("201" + partOfYear + "1115040613555");
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
    }
}

public class HandleDate {
    // this is not thread safe
    private SimpleDateFormat simpleDateFormatTimestampJPOS = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public void verifyNotThreadSafe(String timeStamp) {
        try {
            // this is thread safe
            //SimpleDateFormat simpleDateFormatTimestampJPOS = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            Date date = simpleDateFormatTimestampJPOS.parse(timeStamp);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
            String expectedYear = timeStamp.substring(0, 4);
            String actualYear = String.valueOf(localDateTime.getYear());
            if (!expectedYear.equals(actualYear)) {
                System.out.println("expected:" + expectedYear + ", but real:" + actualYear);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}