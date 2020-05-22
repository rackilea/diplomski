package test;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;


public class TestVM {
    public String getDataOne () {
        return System.currentTimeMillis() % 19 + "";
    }
    public String getDataTwo () {
        return System.currentTimeMillis() % 91 + "";
    }
    @Command
    @NotifyChange({"dataOne", "dataTwo"})
    public void updateData () {

    }
}