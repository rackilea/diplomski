button.setOnClickListener(v -> {
    long currentTime = System.currentTimeMillis();

    if (lastPressedTime == null || (currentTime - lastPressedTime) > 2000) {
        Toast.makeText(v.getContext(), "Tap again to exit", Toast.LENGTH_SHORT).show();
        lastPressedTime = currentTime;
    } else {
        finish();
    }
});