@Parameterized.Parameters
public static Collection userPlusAccount() {
    List<Object[]> list = new ArrayList<>();
    for(int i = 0; i<TestData.getSize(); i++) {
        list.add(new Object[]{TestData.users[i], TestData.accounts[i]});
    }
}