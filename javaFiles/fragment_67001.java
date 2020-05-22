mountPage("/home", HomePage.class);
mountPage("/login", LoginPage.class);
mountPage("/logout", LogoutPage.class);
mountPage("/${nick}/${action}", UserProfilePage.class);
mountPage("/texts/${page}", TextPages.class);
mountPage("/events/${page}", EventPages.class);
mountPage("/fotos/${page}", FotoPages.class);