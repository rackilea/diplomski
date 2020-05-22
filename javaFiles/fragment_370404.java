if (null != mp && null != mp2) {
    if (!isChecked) {
        mp.setVolume(1, 1);
        mp2.setVolume(1, 1);
    } else {
        mp.setVolume(0, 0);
        mp2.setVolume(0, 0);
    }
}