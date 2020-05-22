package jxtest;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TestPojo {

    private final StringProperty myField1 = new SimpleStringProperty();
    private final StringProperty myField2 = new SimpleStringProperty();
    private int myField3 ;

    public final StringProperty myField1Property() {
        return this.myField1;
    }


    public final String getMyField1() {
        return this.myField1Property().get();
    }


    public final void setMyField1(final String myField1) {
        this.myField1Property().set(myField1);
    }


    public final StringProperty myField2Property() {
        return this.myField2;
    }



    public final String getMyField2() {
        return this.myField2Property().get();
    }



    public final void setMyField2(final String myField2) {
        this.myField2Property().set(myField2);
    }


    public int getMyField3() {
        return myField3;
    }


    public void setMyField3(int myField3) {
        this.myField3 = myField3;
    }

}