import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.eden62.GENSMobile.Database.RNFDatabase.RNFInventaire;
import com.example.eden62.GENSMobile.R;
import com.example.eden62.GENSMobile.Tools.MatchableArrayAdapter;

public class RNFMatchableArrayAdapter extends MatchableArrayAdapter<RNFInventaire> {
    public RNFMatchableArrayAdapter(Context context, int resource, List<RNFInventaire> items) {
        super(context, resource);
        addAll(items);
    }
    public boolean latinFilterMode;

    @Override
    protected void onBind(final RNFInventaire item, View itemView, int position) {

        TextView nomEspece = (TextView) itemView.findViewById(R.id.nomEspeceRNFInv);
        final EditText nombre = (EditText) itemView.findViewById(R.id.nombre);
        final EditText nbMale = (EditText) itemView.findViewById(R.id.nbMale);
        final EditText nbFemale = (EditText) itemView.findViewById(R.id.nbFemale);
        Button decNombreButton = (Button) itemView.findViewById(R.id.decDenombrement);
        Button incNombreButton = (Button) itemView.findViewById(R.id.incDenombrement);
        Button decNbMaleButton = (Button) itemView.findViewById(R.id.decNbMale);
        Button incNbMaleButton = (Button) itemView.findViewById(R.id.incNbMale);
        Button decNbFemaleButton = (Button) itemView.findViewById(R.id.decNbFemale);
        Button incNbFemaleButton = (Button) itemView.findViewById(R.id.incNbFemale);

        bindNombreWatcher(nombre, item);
        bindNbMaleWatcher(nbMale, nombre, item);
        bindNbFemaleWatcher(nbFemale, nombre, item);

        String nom;
        String nomFr = item.getNomFr();
        nom = item.getNomLatin();

        if(!nomFr.isEmpty())
            nom += " - " + nomFr;

        nomEspece.setText(nom);

        decNombreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decNombre(item, nombre);
            }
        });

        incNombreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incNombre(item, nombre);
            }
        });


        decNbMaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decNbMale(item, nbMale);
            }
        });

        incNbMaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incNbMale(item, nbMale);
            }
        });

        decNbFemaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decNbFemale(item,nbFemale);
            }
        });

        incNbFemaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incNbFemale(item,nbFemale);
            }
        });

        int nb = item.getNombre();
        int nbMaleInt = item.getNbMale();
        int nbFemaleInt = item.getNbFemale();
        // Si le dénombrement n'a pas été défini
        if(nb != 0)
            nombre.setText(nb + "");
        else
            nombre.setText("");

        if(nbMaleInt != 0)
            nbMale.setText(nbMaleInt + "");
        else
            nbMale.setText("");

        if(nbFemaleInt != 0)
            nbFemale.setText(nbFemaleInt + "");
        else
            nbFemale.setText("");
    }

    @Override
    protected boolean matches(RNFInventaire value, CharSequence constraint, CharSequence lowerCaseConstraint) {
        String itemName;
        if(latinFilterMode)
            itemName = value.getNomLatin().toLowerCase();
        else
            itemName = value.getNomFr().toLowerCase();
        return itemName.startsWith(lowerCaseConstraint.toString());
    }

    @Override
    protected void onViewCreated(View itemView) {
        final EditText nombre = (EditText) itemView.findViewById(R.id.nombre);
        final EditText nbMale = (EditText) itemView.findViewById(R.id.nbMale);
        final EditText nbFemale = (EditText) itemView.findViewById(R.id.nbFemale);

        NombreTW nombreTW = new NombreTW();
        NbFemaleTW nbFemaleTW = new NbFemaleTW(nombre);
        NbMaleTW nbMaleTW = new NbMaleTW(nombre);

        setWatcherToET(nombre, nombreTW);
        setWatcherToET(nbFemale, nbFemaleTW);
        setWatcherToET(nbMale, nbMaleTW);
    }

    private void setWatcherToET(EditText et, BaseTW tw){
        et.addTextChangedListener(tw);
        et.setTag(tw);
    }

    private void bindNombreWatcher(EditText nombre, RNFInventaire item){
        ((NombreTW) nombre.getTag()).item = item;
    }

    //
    private void bindNbMaleWatcher(EditText nbMale, EditText nombre, RNFInventaire item){
        ((NbMaleTW) nbMale.getTag()).item = item;
    }

    private void bindNbFemaleWatcher(EditText nbFemale, EditText nombre, RNFInventaire item){
        ((NbFemaleTW) nbFemale.getTag()).item = item;
    }