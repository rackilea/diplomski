for (int i = 0; i < parentArray.length(); i++) {
                JSONObject finalObject = parentArray.getJSONObject(i);
                FoodModel foodModel = new FoodModel();
                foodModel.setFood(finalObject.optString("name"));
                //foodModel.setStatus(finalObject.optString("status"));
                foodModel.setAmount(finalObject.optInt("amount"));
                foodModel.setDescription(finalObject.optString("description"));
                foodModel.setDate(finalObject.optInt("exDate"));


                foodModelList.add(foodModel);
            }