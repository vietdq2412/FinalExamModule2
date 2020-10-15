import java.io.Serializable;

public class Contact implements Serializable {
    private int phoneNumber;
    private String group;
    private String fullName;
    private String gender;
    private String address;
    private String dateOfbirth;
    private String email;

    public Contact() {
    }

    public Contact(int phoneNumber, String fullName, String group, String gender, String address, String dateOfbirth, String email) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.fullName = fullName;
        this.gender = gender;
        this.address = address;
        this.dateOfbirth = dateOfbirth;
        this.email = email;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDateOfbirth(String dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfbirth() {
        return dateOfbirth;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return String.format("|Số điện thoại: %-13d|Họ tên: %-20s|Nhóm:%-10s" +
                "\n|Ngày sinh: %-17s|Email: %-25s" +
                "\n|Địa chỉ: %-50s" +
                "\n---------------------------------------------------------------------------------------"
                , phoneNumber, fullName, group, dateOfbirth, email, address);
    }
}
