class ServiceExecutor {
    void runLongRoutine() {
        try {
            runLongRoutine0();
        } catch (CustomException e) {
            //5-10 lines of code
        } catch (IOException e) {
            //5-10 lines of code
        } catch (NetworkException e) {
            //5-10 lines of code
        }
        //to be continued
    }

    private void runLongRoutine0() throws CustomException, IOException, NetworkException {
        several(param1);
        calls();
        to(param2);
        different(param3, param1);
        methods();
    }
}