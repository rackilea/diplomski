package de.professional_webworkx.reservationmanager.model;

import java.time.LocalDate;
import java.util.Random;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Reservation entity
 * @author Patrick Ott <Patrick.Ott@professional-webworkx.de>
 * @version 1.0
 */
public class Reservation {

    private IntegerProperty reserveNumberProperty;
    private StringProperty customerNameProperty;

    private ObjectProperty<LocalDate> checkIn;
    private ObjectProperty<LocalDate> checkOut;

    public Reservation() {
        reserveNumberProperty   = new SimpleIntegerProperty(generateReservationNumber());
        customerNameProperty    = new SimpleStringProperty();
        checkIn                 = new SimpleObjectProperty<>();
        checkOut                = new SimpleObjectProperty<>();
    }

    public Reservation(final String customerName, final LocalDate checkIn, final LocalDate checkOut) {
        reserveNumberProperty   = new SimpleIntegerProperty(generateReservationNumber());
        customerNameProperty    = new SimpleStringProperty(customerName);
        this.checkIn            = new SimpleObjectProperty<>(checkIn);
        this.checkOut           = new SimpleObjectProperty<>(checkOut);
    }

    /**
     * @return the reserveNumberProperty
     */
    public IntegerProperty getReserveNumberProperty() {
        return reserveNumberProperty;
    }

    public Integer getReserveNumber() {
        return reserveNumberProperty.get();
    }

    /**
     * @param reserveNumberProperty the reserveNumberProperty to set
     */
    public void setReserveNumberProperty(IntegerProperty reserveNumberProperty) {
        this.reserveNumberProperty = reserveNumberProperty;
    }

    /**
     * @return the customerNameProperty
     */
    public StringProperty getCustomerNameProperty() {
        return customerNameProperty;
    }

    public String getCustomerName() {
        return customerNameProperty.get();
    }

    /**
     * @param customerNameProperty the customerNameProperty to set
     */
    public void setCustomerNameProperty(StringProperty customerNameProperty) {
        this.customerNameProperty = customerNameProperty;
    }

    /**
     * @return the checkIn
     */
    public ObjectProperty<LocalDate> getCheckInProperty() {
        return checkIn;
    }

    public LocalDate getCheckIn() {
        return checkIn.getValue();
    }

    /**
     * @param fromProperty the checkIn to set
     */
    public void setCheckInProperty(ObjectProperty<LocalDate> fromProperty) {
        this.checkIn = fromProperty;
    }

    /**
     * @return the checkOut
     */
    public ObjectProperty<LocalDate> getCheckOutProperty() {
        return checkOut;
    }

    public LocalDate getCheckOut() {
        return checkOut.getValue();
    }

    /**
     * @param toProperty the checkOut to set
     */
    public void setCheckOutProperty(ObjectProperty<LocalDate> toProperty) {
        this.checkOut = toProperty;
    }

    private Integer generateReservationNumber() {
        Random random = new Random();
        int nextInt = random.nextInt();
        return new Integer(nextInt);
    }
}