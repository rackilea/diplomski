@RestController
@Validated
open class GetCrab {
    @GetMapping("/v1/get")
    open fun getNameOfDayByNumber(@RequestParam dayOfWeek: @Min(1) @Max(7) Int?): String {
        return "ok"
    }
}