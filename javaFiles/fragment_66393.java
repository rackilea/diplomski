public Double extract(String word)
{
    Double total = new Double(0);
    if(_dict.get(word+"#n") != null)
         total = _dict.get(word+"#n") + total;
    if(_dict.get(word+"#a") != null)
        total = _dict.get(word+"#a") + total;
    if(_dict.get(word+"#r") != null)
        total = _dict.get(word+"#r") + total;
    if(_dict.get(word+"#v") != null)
        total = _dict.get(word+"#v") + total;
    return total;
}