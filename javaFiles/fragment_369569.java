@RequestMapping("/utilities/longProcessStream")
public StreamingResponseBody asyncLongProcessStream(HttpServletResponse response, HttpServletRequest request) {
    response.addHeader("Content-Type", MediaType.APPLICATION_JSON);
    return new StreamingResponseBody() {
        @Override
        public void writeTo(OutputStream outputStream) throws IOException {
            PMDController.this.callURL(response, request, outputStream);
        }
    };
}