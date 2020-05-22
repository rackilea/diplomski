import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ngtnttnmnt.xtool.InputFilterMinMax;
import com.ngtnttnmnt.xtool.R;

public class binary_numbers extends Fragment {

public binary_numbers() {
    // Required empty public constructor
}

public static binary_numbers newInstance() {
    binary_numbers fragment = new binary_numbers();
    return fragment;
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_binary_numbers, container, false);
    EditText et_input = (EditText) view.findViewById(R.id.et_input);
    et_input.setText("TEST");

    // Inflate the layout for this fragment
    return view;
}
}