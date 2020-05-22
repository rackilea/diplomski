package com.stackoverflow.q2936686;

import java.util.Calendar;

public class ElapsedTimeWithCalendar {

    public static void main(String[] args) throws Exception {
        Calendar birthDate = Calendar.getInstance();
        birthDate.set(1978, 3 - 1, 26, 12, 35, 0); // My birthdate.
        Calendar now = Calendar.getInstance(); // Now.

        Integer[] elapsed = new Integer[6];
        Calendar clone = (Calendar) birthDate.clone(); // Otherwise changes are been reflected.
        elapsed[0] = elapsed(clone, now, Calendar.YEAR);
        clone.add(Calendar.YEAR, elapsed[0]);
        elapsed[1] = elapsed(clone, now, Calendar.MONTH);
        clone.add(Calendar.MONTH, elapsed[1]);
        elapsed[2] = elapsed(clone, now, Calendar.DATE);
        clone.add(Calendar.DATE, elapsed[2]);
        elapsed[3] = (int) (now.getTimeInMillis() - clone.getTimeInMillis()) / 3600000;
        clone.add(Calendar.HOUR, elapsed[3]);
        elapsed[4] = (int) (now.getTimeInMillis() - clone.getTimeInMillis()) / 60000;
        clone.add(Calendar.MINUTE, elapsed[4]);
        elapsed[5] = (int) (now.getTimeInMillis() - clone.getTimeInMillis()) / 1000;

        System.out.format("%d years, %d months, %d days, %d hours, %d minutes, %d seconds%n", elapsed);
    }

    private static int elapsed(Calendar before, Calendar after, int field) {
        Calendar clone = (Calendar) before.clone(); // Otherwise changes are been reflected.
        int elapsed = -1;
        while (!clone.after(after)) {
            clone.add(field, 1);
            elapsed++;
        }
        return elapsed;
    }

}