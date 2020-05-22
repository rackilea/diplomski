boolean overlap = false;
if (resBstart.equals(resAstart)) { // scenario 1
    overlap = true;
} else if (resBstart.after(resAstart) && resBstart.before(resAend)) { // scenario 2
    overlap = true;
} else if (resBend.equals(resAend)) { // scenario 3
    overlap = true;
} else if (resBend.after(resAstart) && resBend.before(resAend)) { // scenario 4
    overlap = true;
} else if (resBstart.before(resAstart) && resBend.after(resAend)) { // scenario 5
    overlap = true;
}