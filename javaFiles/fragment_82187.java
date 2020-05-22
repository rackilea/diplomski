public class CustomerListActivity extends AppCompatActivity {
    List<Customer> list = Customer.getClients();
    public void yourMethod(){
        list.get(0).getData()[0] = "999";
    }
}