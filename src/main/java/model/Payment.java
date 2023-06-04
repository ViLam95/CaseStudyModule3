package model;

import java.time.LocalDate;

public class Payment {
    private int payment_id;
    private LocalDate payment_date;
    private double payment_among;
    private String payment_status;

    public Payment() {
    }

    public Payment(int payment_id, LocalDate payment_date, double payment_among, String payment_status) {
        this.payment_id = payment_id;
        this.payment_date = payment_date;
        this.payment_among = payment_among;
        this.payment_status = payment_status;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public LocalDate getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(LocalDate payment_date) {
        this.payment_date = payment_date;
    }

    public double getPayment_among() {
        return payment_among;
    }

    public void setPayment_among(double payment_among) {
        this.payment_among = payment_among;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + payment_id +
                ", payment_date=" + payment_date +
                ", payment_among=" + payment_among +
                ", payment_status='" + payment_status + '\'' +
                '}';
    }
}
