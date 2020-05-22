private void rerunAnimation() {
    transition.stop();
    // if needed set different text on "node"
    recalculateTransition();
    transition.playFromStart();
}