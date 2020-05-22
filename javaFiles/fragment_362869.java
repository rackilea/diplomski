enum OS { WINDOWS, MAC, LINUX, OTHER }

ObjectProperty<OS> os = new SimpleObjectProperty<>(OS.MAC);

Option<OS> OSOption = new DefaultOption(MaterialDesignIcon.LAPTOP.graphic(), "Operative System", 
            "Set the preferred OS", "Operative System", os, true);