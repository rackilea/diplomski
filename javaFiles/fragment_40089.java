class IndexController{

    @Secured(closure = {
        authentication.name == 'admin'
    })
    def admin(){
        render("Admin things")
    }

}