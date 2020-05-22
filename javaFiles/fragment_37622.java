1) scene.getStylesheets().add("application.css");

2) scene.getStylesheets().add(this.getClass().getResource("/application.css").toString());

3) Package should be inside src directory and css also should be in src directory.
scene.getStylesheets().add(<packageName>.<ClassName>.class.getResource("/application.css").toExtern‌​alForm());