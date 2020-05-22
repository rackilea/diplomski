private void func (ArrayList <? super Double> array, String JSON)
{
    ...
    array.add (NumberFormat.getInstance ().parse (JSON.substring (...)));
    ...
}

ArrayList <Number> temp = new ArrayList ();
func (temp, json);
floatArray [i] = temp.get (i).floatValue ();