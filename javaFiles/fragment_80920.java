registerAuthenticationSuccess() {
     this.eventManager.subscribe('authenticationSuccess', (message) => {
        this.principal.identity().then((account) => {
            if (account.authorities.indexOf("ROLE_X") >=0)
            {
                this.router.navigate(['PATHTOYOURPAGE']);
            }
            else
            {
                this.account = account;
            }
        }); 
     });
   }