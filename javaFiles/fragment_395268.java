class BaseViewModel {
    BaseViewHolder  holder;


   //You can call this setter with any subclass of BaseViewHolder  without casting!
    void setHolder(BaseViewHolder  holder) {
        this.holder = holder;
    }
}


class BaseViewHolder {
    BaseViewModel model;

   //You can call this setter with any subclass of BaseViewModel without casting!
    void setModel(BaseViewModel  model) {  
        this.model = model;
        model.setHolder( this);
    }
}