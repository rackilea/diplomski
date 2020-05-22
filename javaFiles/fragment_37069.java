package de.scrum_master.aspect;

import com.commercial.app.CommercialAppActivity;

public aspect AppManipulatorAspect {
    public boolean CommercialAppActivity.onCreateOptionsMenu(Object obj) {
        System.out.println("onCreateOptionsMenu implementation overridden by aspect");
        return false;
    }
}