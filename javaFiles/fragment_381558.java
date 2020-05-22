stage.act();

if (changed == false) {
    return;
} else if (++count == 2) {
    changed = false;
}