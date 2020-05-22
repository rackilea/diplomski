public void Recal(){ 
do{
    this.GetDet();
    this.SearchArr();
    double Price = this.CalPrice();
    this.TotalPrice();
}while(d==1);
}