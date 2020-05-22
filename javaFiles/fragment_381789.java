finalGrade = (mp1 * .2) + (mp2 * .2) + (exam1 * .1) + (mp3 * .2)
            + (mp4 * .2) + (exam2 * .1);

    return finalGrade;
}

public static char getLetter(double finalGrade) {
    if (finalGrade >= 89.5)
        return 'A';
    else if (finalGrade >= 79.5 && finalGrade < 89.5)
        return 'B';
    else if (finalGrade >= 69.5 && finalGrade < 79.5)
        return 'C';
    else if (finalGrade >= 59.5 && finalGrade < 69.5)
        return 'D';
    else
        return 'F';
}