package test.pckg.dto

   public class LogDTO {
        private String message;
        private LocalDateTime date;
        public LogDTO(String message, LocalDateTime date){
            this.message = message;
            this.date = date;
        }
        //getters and setters
    }