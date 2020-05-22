@RestController
 public class WalletController {

@Autowired
WalletRepository walletRepository;
@Autowired
UserRepository userRepository;

@RequestMapping(value = "/createWallet")
public ResponseEntity<String> createWallet() {
    Wallet wallet = new Wallet();
    List<User> userList = userRepository.findUserLastLoggedIn();
    if (userList == null) {
        return new ResponseEntity<>("Active user not found. You must login 
 to the system.", HttpStatus.OK);
    }
    if (userList.size() == 1) {
        User user = null;//userList.get(0);
        wallet.setwOwnerId(Integer.parseInt(user.get_id()));
        WalletKey walletKey = WalletKey.getWalletKeys();
        wallet.setwPubKey(walletKey.getPublicKey());
        wallet.setwZeugma(walletKey.getPrivateKey());
        wallet.setwNumber(walletKey.getWalletNumber());
        walletRepository.save(wallet);
        return new ResponseEntity<>("Wallet created.", HttpStatus.OK);
    }
    return new ResponseEntity<String>("Wallet creation failed", 
 HttpStatus.OK);
}
}