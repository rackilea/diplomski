public class custom_adapter extends ArrayAdapter<MyClass>{

public custom_adapter(Context context, ArrayList<MyClass> horarios) {
    super(context, R.layout.costum_listview ,horarios);
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater horarioInflater = LayoutInflater.from(getContext());
    View costumView = horarioInflater.inflate(R.layout.costum_listview, parent, false);

    MyClass singleHorario = getItem(position);
    TextView hora = (TextView) costumView.findViewById(R.id.Hora);
    TextView nota = (TextView) costumView.findViewById(R.id.Nota);

    hora.setText(singleHorario.hora);
    nota.setText(singleHorario.nota);

    return costumView;
}