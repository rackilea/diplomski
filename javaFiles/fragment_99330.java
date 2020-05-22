holderView.state.setOnClickListener(this);
 holderView.view.setOnClickListener(this);
 holderView.comp.setOnClickListener(this);

 @Override
public void onClick(View v) {
    if (v.getId() == R.id.id1
            || v.getId() == R.id.id2
            || v.getId() == R.id.id3) {
        // Do your task here
    }
}