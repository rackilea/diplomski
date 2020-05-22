@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseStatus(HttpStatus.CREATED) AccountCreateResponse add(@RequestBody() AccountCreateRequest account) {
        AccountCreateResponse response = new AccountCreateResponse(account.getUserName(), account.getPassword());
        return response;
    }
}