package model;

public class OptionPartner {
    private int id;
    private Optional optional;
    private Partner partner;

    public OptionPartner() {
    }

    public OptionPartner(int id, Optional optional, Partner partner) {
        this.id = id;
        this.optional = optional;
        this.partner = partner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Optional getOptional() {
        return optional;
    }

    public void setOptional(Optional optional) {
        this.optional = optional;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }
}
