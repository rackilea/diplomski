PasswordTextField ptf = new PasswordTextField("password", Model.of(""));

    Form form = new Form("exampleForm"){
                @Override
                public void onSubmit() {
                   System.out.print(ptf.getModelObject());
                }
    }
    form.add(ptf);