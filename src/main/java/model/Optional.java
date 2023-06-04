package model;


public class Optional {
    private int optional_id;
    private String optional_name;
    private String description;
    private double optional_price;

    public Optional() {
    }

    public Optional(int optional_id, String optional_name, String description, double optional_price) {
        this.optional_id = optional_id;
        this.optional_name = optional_name;
        this.description = description;
        this.optional_price = optional_price;
    }

    public Optional(int optionalId, String optionalName) {
    }

    public Optional(String optionalName, String description, double optionalPrice) {
    }

    public int getOptional_id() {
        return optional_id;
    }

    public void setOptional_id(int optional_id) {
        this.optional_id = optional_id;
    }

    public String getOptional_name() {
        return optional_name;
    }

    public void setOptional_name(String optional_name) {
        this.optional_name = optional_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getOptional_price() {
        return optional_price;
    }

    public void setOptional_price(double optional_price) {
        this.optional_price = optional_price;
    }

    @Override
    public String toString() {
        return "Optional{" +
                "optional_id=" + optional_id +
                ", optional_name='" + optional_name + '\'' +
                ", description='" + description + '\'' +
                ", optional_price=" + optional_price +
                '}';
    }
}
