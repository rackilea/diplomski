public Result test() {
        Form<Store> storeForm = Form.form(Store.class);
        Store store = storeForm.bindFromRequest().get();
        System.out.println(Json.toJson(store));

        if (store.getAmount() > 0) {
            //update
            System.out.println("perform update");
        } else {
            //save or recharge
            System.out.println("perform recharge");
        }
        return ok();
    }