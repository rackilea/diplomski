public void changeFlowers(int i)
{

    if(null!=this._fishes && this._fishes.size()>i){

        FlowerOne f1 = (FlowerOne)(this._fishes.get(i));
        f1.changeColor(this._theme);
}


}