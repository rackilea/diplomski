@Override
public void onClick(View v) {

        klik10--;
        tombolbaca.setText("Baca " + klik10 + "x");

        if (klik10 <= 0)
        {
            mTitle.setVisibility(View.GONE);
            rl2.setVisibility(View.GONE);
        }
}