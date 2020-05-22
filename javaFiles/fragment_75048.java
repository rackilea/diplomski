try {
    Thread.sleep(700);
} catch (InterruptedException e) {
    selenium.keyPressNative("27"); // Escape
    selenium.keyPressNative("10"); // Enter 
}