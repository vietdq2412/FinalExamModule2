import java.io.IOException;

public class Menu {
    private ContactsListManager manager = new ContactsListManager();
    private Inputer inputer = new Inputer();
    private final String MENU =
            "____________________________________"
                    + "\n|---CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ---|"
                    + "\n|Chọn chức năng theo số để tiếp tục:"
                    + "\n|1. Xem dnah sách"
                    + "\n|2. Thêm mới"
                    + "\n|3. Cập nhật"
                    + "\n|4. Xóa"
                    + "\n|5. TÌm kiếm"
                    + "\n|6. Đọc từ file"
                    + "\n|7. Ghi vào file"
                    + "\n|8. Thoát" +
                    "Chon chức năng: ";

    public Menu() {
    }

    public void run() {
        try {
            manager.getDataFromFile();
        } catch (IOException e) {
            System.out.println("Danh sách trống!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int choice;
        do {
            System.out.println(MENU);
            choice = inputer.inputInt("Enter your choice: ");
            setupMenu(choice);
        } while (choice != 8);

    }

    private void setupMenu(int choice) {
        switch (choice) {
            case 1:
                boolean isDone = manager.showContactList();
                if (!isDone){
                    System.out.println("danh sách trống!");
                }
                break;
            case 2:
                int phoneNumber = inputer.inputPhoneNumber("Nhập số điện thoại: ");
                String fullName = inputer.inputString("Nhập họ tên: ");
                String group = inputer.inputString("Nhập nhóm: ");
                String gender = inputer.inputString("Nhập giới tính: ");
                String address = inputer.inputString("Nhập địa chỉ: ");
                String dateOfBirth = inputer.inputString("Nhập ngày sinh: ");
                String email = inputer.inputEmail("Nhập Email: ");
                manager.addProduct(phoneNumber, fullName, group, gender, address, dateOfBirth, email);
                break;
            case 3:
                phoneNumber = inputer.inputInt("Nhập số điện thoại cần sửa: ");
                fullName = inputer.inputString("Nhập họ tên mới: ");
                group = inputer.inputString("Nhập nhóm mới: ");
                gender = inputer.inputString("Nhập giới tính mới: ");
                address = inputer.inputString("Nhập địa chỉ mới: ");
                dateOfBirth = inputer.inputString("Nhập ngày sinh mới: ");
                email = inputer.inputEmail("Nhập Email mới: ");
                isDone = manager.editContact(phoneNumber, fullName, group, gender, address, dateOfBirth, email);
                if (!isDone){
                    System.out.println("không tìm thấy só điện thoại");
                }
                break;
            case 4:
                phoneNumber = inputer.inputInt("Nhập sdt cần xóa");
                manager.deleteContact(phoneNumber);
                break;
            case 5:
                phoneNumber = inputer.inputInt("số cần tìm: ");
                Contact rs = manager.searchContact(phoneNumber);
                System.out.println(rs.toString());
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
            default:
        }
    }
}
