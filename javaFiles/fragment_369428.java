package mypackage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

public class MyBean {

    private static List<SelectItem> days = new ArrayList<SelectItem>();
    private static List<SelectItem> months = new ArrayList<SelectItem>();
    private static List<SelectItem> years = new ArrayList<SelectItem>();

    static {
        // Just do your thing to fill them. Only ensure that those are Strings,
        // else you'll need to change the type in Converter accordingly.
        for (int i = 1; i <= 31; i++) days.add(new SelectItem(String.valueOf(i)));
        for (int i = 1; i <= 12; i++) months.add(new SelectItem(String.valueOf(i)));
        for (int i = 2000; i <= 2020; i++) years.add(new SelectItem(String.valueOf(i)));
    }

    private Date date;

    public void submit() {
        // Print submitted date to stdout.
        System.out.println("Submitted date: " + date);
    }

    public List<SelectItem> getDays() {
        return days;
    }

    public List<SelectItem> getMonths() {
        return months;
    }

    public List<SelectItem> getYears() {
        return years;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}