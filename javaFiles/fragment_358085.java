public class Test {

    public static void main(String[] args) {
        SCD_Checker checker = new SCD_Checker();
        Future<WorkerDTO> workerDTOFuture = checker.submit_task("test@test.com");
        WorkerDTO workerDTO = workerDTOFuture.get();
        String email = workerDTO.getEmail();
        String stat = workerDTO.getStat();
    }
}