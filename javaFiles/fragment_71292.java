@Override
public void onClick(View view) {

    if(view instanceof shooter) {
        cannon.move();
    }
    else if(view instanceof shoot) {
        bullets.remove();
    }
}