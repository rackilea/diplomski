@override
public void onClick(View view){
    if (!calClickedStatus.get(view.getId())) {
        calClickedStatus.put(view.getId(), true);

        //the view here is actually the clicked ImageView, so just cast it and use it, replace this
        //ivCalArrow1.setImageResource(R.drawable.arrow_symbol_up);
        //with this
        ((ImageView)view).setImageResource(R.drawable.arrow_symbol_up);

        //now for this, you may want to use an array of TextView to hold tvDescription1, tvDescription2 ...
        //and make a map to link each tvDescriptionX to the index of licked image
        tvDescription1.setVisibility(View.VISIBLE);
    } else {
        //do same changes here too
        calClickedStatus.put(view.getId(), false);
        ivCalArrow1.setImageResource(R.drawable.arrow_symbol_down);
        tvDescription1.setVisibility(View.GONE);
    }
}