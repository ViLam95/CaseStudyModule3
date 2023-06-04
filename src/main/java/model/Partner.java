package model;

public class Partner {
    private int partner_id;
    private String partner_name;
    private String partner_email;
    private String partner_gender;
    private int age;
    private String partner_status;
    private String partner_phone;
    private String partner_address;

    public Partner() {
    }

    public Partner(int partner_id, String partner_name, String partner_email, String partner_gender,
                   int age, String partner_status, String partner_phone, String partner_address) {
        this.partner_id = partner_id;
        this.partner_name = partner_name;
        this.partner_email = partner_email;
        this.partner_gender = partner_gender;
        this.age = age;
        this.partner_status = partner_status;
        this.partner_phone = partner_phone;
        this.partner_address = partner_address;
    }

    public Partner(int partnerId, String partnerName) {

    }

    public Partner(String partnerName) {
    }

    public Partner(String partnerName, String partnerEmail, String partnerGender, int age, String partnerStatus, String partnerPhone, String partnerAddress) {
    }

    public int getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(int partner_id) {
        this.partner_id = partner_id;
    }

    public String getPartner_name() {
        return partner_name;
    }

    public void setPartner_name(String partner_name) {
        this.partner_name = partner_name;
    }

    public String getPartner_email() {
        return partner_email;
    }

    public void setPartner_email(String partner_email) {
        this.partner_email = partner_email;
    }

    public String getPartner_gender() {
        return partner_gender;
    }

    public void setPartner_gender(String partner_gender) {
        this.partner_gender = partner_gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPartner_status() {
        return partner_status;
    }

    public void setPartner_status(String partner_status) {
        this.partner_status = partner_status;
    }

    public String getPartner_phone() {
        return partner_phone;
    }

    public void setPartner_phone(String partner_phone) {
        this.partner_phone = partner_phone;
    }

    public String getPartner_address() {
        return partner_address;
    }

    public void setPartner_address(String partner_address) {
        this.partner_address = partner_address;
    }

    @Override
    public String toString() {
        return "Partner{" +
                "partner_id=" + partner_id +
                ", partner_name='" + partner_name + '\'' +
                ", partner_email='" + partner_email + '\'' +
                ", partner_gender='" + partner_gender + '\'' +
                ", age=" + age +
                ", partner_status='" + partner_status + '\'' +
                ", partner_phone='" + partner_phone + '\'' +
                ", partner_address='" + partner_address + '\'' +
                '}';
    }
}
