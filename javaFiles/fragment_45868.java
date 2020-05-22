public boolean isVoNotNull() {
    return null != this.cardNo &&  StringUtils.isNotBlank(this.cardNo) 
        && null != this.otp && StringUtils.isNotBlank(this.otp) 
        && null != this.password && StringUtils.isNotBlank(this.password)
        && null != this.userid && StringUtils.isNotBlank(this.userid) 
        && null != this.type && StringUtils.isNotBlank(this.type) 
        && null != this.walletMobileNo && StringUtils.isNotBlank(this.walletMobileNo);
}