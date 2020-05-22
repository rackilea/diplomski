public Result save() {

        Form<Computer> computerForm = formFactory.form(Computer.class).bindFromRequest();
        if(computerForm.hasErrors()) 
            {return badRequest(views.html.computers.createForm.render(AuthorisedUser.findByEmail(request().username()), computerForm));}


        try 
        {
            Computer computerData = computerForm.get();

            Computer computer = new Computer();

            computer.name = computerData.name;
            computer.active = computerData.active;
            computer.status = computerData.status;
            computer.introduced = computerData.introduced;

            computer.save();
            flash("success", "Computer [ " + computerForm.get().name + " ] has been created");

        return GO_HOME;


        } 
        catch (Exception e) 
        {
            Logger.error("add.computer.save error", e);
            flash("erreur", "Computer [ " + computerForm.get().name + " ] has not been created");
        }   


        return GO_HOME;

        /*String refererUrl = request().getHeader("referer");
        return redirect(refererUrl);*/
    }