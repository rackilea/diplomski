public class MainActivity extends Activity {

private ListView lvDetails;
private Context ctx;
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.ticket_details);
ctx=this;
List<TicketObjects> ticketObjectses = new ArrayList<>();
ticketObjectses.add(new TicketObjects("Бишкек", "Манас", "Ош", "Аэропорт Оша", "FRU", "13:45", "16.09.2015", "OSS", "13:45", "16.09.2015", "Almaty", "1ч 15мин", "15000", R.drawable.logo_flyduba, "Рейс: 543"));
ticketObjectses.add(new TicketObjects("Ош", "Аэропорт Оша", "Новосибирск", "Толмачево", "OSS", "15:43", "16.09.2015", "OVB", "17:45", "16.09.2015", "Astana", "1ч 25мин", "16000", R.drawable.logo_kazak, "Рейс: 543"));
ticketObjectses.add(new TicketObjects("Алматы", "Алматы", "Москва", "Домодедово","ALA","11:54","16.09.2015","DME","12:44","16.09.2015","Novosibirsk", "2ч 15мин","13000", R.drawable.logo_pegasus_logo, "Рейс: 543"));

lvDetails = ( ListView ) findViewById( R.id.lvDetails);

View header = getLayoutInflater().inflate(R.layout.ticket_details_header_item,lvDetails,false);
TextView text1 = (TextView) header.findViewById(R.id.detTitleArriveCity);
TextView text2 = (TextView) header.findViewById(R.id.detTotalDuration);
// do the same far all your text views or what ever you want to get from layout.
TicketObjects mTicketObjects = ticketObjectses.get(0);
text1.setText(mTicketObjects.getDepartCity());
text2.setText(mTicketObjects.getFlyDuration());
// do the same for other options. 
lvDetails.addHeaderView(header);
lvDetails.setAdapter(new DetailsAdapter(ctx, R.layout.ticket_details_item, ticketObjectses));
}
}