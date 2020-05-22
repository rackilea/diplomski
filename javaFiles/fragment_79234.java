@FXML private MenuItem settingsMenu;
    @FXML
    public void initialize(URL location, ResourceBundle resources) {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Doctor currentUser = (Doctor) doctorService.findDoctorByDoctorUsername(authentication.getName());

    if(!currentUser.getRoles().contains(Role.ADMIN)) {
    settingsMenu.getParentMenu().getItems().remove(settingsMenu);
    }

    }