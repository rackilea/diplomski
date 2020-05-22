Observable.from(dishes)
    .flatMap(new Func1<Dish, Observable<OrderLine>>() {
        @Override
        public Observable<OrderLine> call(Dish dish) {
            List<OrderLine> orderLines = new ArrayList<>();
            orderLines.add(new OrderLine(dish.name, dish.price);

            for (Topping topping : dish.toppings) {
                orderLines.add(new OrderLine(topping.name, topping.price);
            }

            if(dish.note != null) {
                orderLines.add(new OrderLine(dish.note, "");
            }
            return Observable.from(orderLines);
        }
    })
    .subscribe(new Action1<OrderLine>() {
        @Override
        public void call(OrderLine orderLine) {
            ...
        }
    });