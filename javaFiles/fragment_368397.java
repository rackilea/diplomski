private class Wallet {
}

private class ChequeStatus {
}

private class ChequeWallet extends Wallet {
}

public class Payout<W extends Wallet> {
    private String id;
    private String userId;
    protected W userWalletInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Wallet getUserWalletInfo() {
        return userWalletInfo;
    }

    public void setUserWalletInfo(W userWalletInfo) {
        this.userWalletInfo = userWalletInfo;
    }
}

public class PayoutCheque extends Payout<ChequeWallet> {
    private String serialNumber;
    private ChequeStatus status;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public ChequeStatus getStatus() {
        return status;
    }

    public void setStatus(ChequeStatus status) {
        this.status = status;
    }

    @Override
    public void setUserWalletInfo(ChequeWallet userWalletInfo) {
        super.setUserWalletInfo(userWalletInfo);
    }
}