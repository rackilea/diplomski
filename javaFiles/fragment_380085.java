public static String calculateSc(int point) { 
        if (point <= 100 && point >= 80) {
            return "You got A+";
        } else if (point <= 60 && point >= 70) {
            return  "You got A";
        } else {
            return "You got F (Failed)";
        }
    }