public void onClick(View view) {

     String checkbox = "";
CompleteOrder completeOrder=new CompleteOrder();
    List<OrderItem> masterProductorderCount=new ArrayList<>();
    for (ProductModel hold : productAdapter.getAllData()) {
                int total = Integer.parseInt(hold.getProduct_price())*(hold.getCountProduct());
                if (hold.isCheckbox()) {
                    checkbox += "\n" + hold.getProduct_name() + " " + total;

                    masterProductorderCount.add(new OrderItem(holder.getProduct_name(),total);

                }

            }
completeOrder.setOrder_items(masterProductorderCount);
     if (!checkbox.isEmpty()) {
                dipilih = checkbox;
            } else {
                dipilih = "Anda Belum Memilih Menu.";
            }

            formSubmit(completeOrder);//pass object of CompleteOrder
        }
     });