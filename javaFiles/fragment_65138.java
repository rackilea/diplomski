public FoodItem(FoodItem otherFoodItem)
     {
        this._name = otherFoodItem.getName();
        this._catalogueNumber = otherFoodItem.getCatalogueNumber();
        this._quantity = otherFoodItem.getQuantity();
        this._prodactionDate = otherFoodItem.getProdactionDate();
        this._expiryDate = otherFoodItem.getExpiryDate();
        this._minTemperature = otherFoodItem.getMinTemperature();
        this._maxTemperature = otherFoodItem.getMaxTemperature();

        //ADD THIS
        this._price = otherFoodItem.getPrice();
     }