startButton.setOnClickListener(this);
    }

@Override
public void onClick(View v) {
    textActivity = spinner_activity.getSelectedItem().toString();
    switch(v.getId()){

        case R.id.startButton:
        {
            if(textActivity == "Entree"){
                Intent i = new Intent(this, BadgeEntree.class);
                startActivity(i);
            }
            break;
        }
    }