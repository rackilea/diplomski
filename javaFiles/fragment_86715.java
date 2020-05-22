long totalSeconds = TimeUnit.MINUTES.toSeconds(5); // 300

    long minutes = TimeUnit.SECONDS.toMinutes(totalSeconds);
    long secondsPart = totalSeconds - TimeUnit.MINUTES.toSeconds(minutes);
    String formattedDuration = String.format("%02d:%02d", minutes, secondsPart);
    System.out.println("Formatted duration: " + formattedDuration);