C c = GenericScreenDataBean fieldObjx = this.expenseLineItemList.stream()
                .flatMap(a -> a.getSectionModel().getControls().stream())
                .filter(b -> b.getData() instanceof GenericScreenDataBean)
                .map(Controls::getData)
                .map(GenericScreenDataBean.class::cast)
                .filter(c->c.getFieldKey().equals("IncurredAmount")).findAny().orElse(null);