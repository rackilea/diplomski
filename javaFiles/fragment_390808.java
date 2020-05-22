int[] views = new int[]{R.id.Radek_2,R.id.Radek_3,R.id.Radek_4};//...
int counter = 0;
public void PridejDalsiStaniceniClicked(View v)
{
    findViewById(views[counter]).setVisibility(View.VISIBLE);
    if(counter<views.length){
        counter++;
    }
}