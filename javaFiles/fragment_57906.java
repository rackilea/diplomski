private void stop() {
    try {
        frame.dispose();
        thread.join();
    } catch (IllegalStateException e) {
        //Do nothing
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println("Program closed, processes halted");
}