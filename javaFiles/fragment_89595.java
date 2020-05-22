public class App {

    public static void main(String[] args) {
        for (int responseCode = 0; responseCode <= 2; responseCode++) {
            UploadResponse response = UploadResponse.getUploadResponse(responseCode);
            System.out.println(response.getMessage());
        }
    }

    private enum UploadResponse {
        SUCCESS(0, "upload successful"),
        FILE_SIZE_ERROR(1, "file too big"),
        FILE_SAVE_ERROR(2, "could not save file");

        private int code;
        private String message;

        private UploadResponse(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public static UploadResponse getUploadResponse(int code) {
            for (UploadResponse response : UploadResponse.values()) {
                if (response.code == code) {
                    return response;
                }
            }

            throw new IllegalArgumentException("Unsupported UploadResponse code: " + code);
        }
    }
}