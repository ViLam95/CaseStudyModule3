package model;

import java.time.LocalDate;

public class Booking {
    private int booking_id;
    private LocalDate booking_date;
    private String booking_status;
    private Users users;
    private Optional optional;
    private Partner partner;

    public Booking() {
    }

    public Booking(int booking_id, LocalDate booking_date, String booking_status,
                   Users users, Optional optional, Partner partner) {
        this.booking_id = booking_id;
        this.booking_date = booking_date;
        this.booking_status = booking_status;
        this.users = users;
        this.optional = optional;
        this.partner = partner;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "booking_id=" + booking_id +
                ", booking_date=" + booking_date +
                ", booking_status='" + booking_status + '\'' +
                ", users=" + users +
                ", optional=" + optional +
                ", partner=" + partner +
                '}';
    }
}
