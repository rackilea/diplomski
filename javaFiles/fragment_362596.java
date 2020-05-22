@RequestMapping("/locationSnapshot/{userId}/{pointInTime}")
public MyResponse getLocationInTime(
        @PathVariable(value="userId") Long userId,
        @PathVariable(value="pointInTime")
        @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss") LocalDateTime pointInTime) {

    MyResponse response = new MyResponse();
    return response;
}