@OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
@Filter(name = "myFilter", condition = ":nameParameter = name")
private List<Account> accounts;

public List<Account> getAccounts() {
    return accounts;
}