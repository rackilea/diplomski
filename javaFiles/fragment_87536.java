@PostMapping(value = "/generateAddress")
    public String generateAddress() {

        walletService.generateAddress();
        return "redirect:/";
    }