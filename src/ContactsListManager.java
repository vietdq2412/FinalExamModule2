import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactsListManager {
    private List<Contact> listContacts = new ArrayList<>();

    public ContactsListManager() {
    }

    public void addProduct(int phoneNumber, String fullName, String group, String gender, String address, String dateOfBirth, String email) {
        Contact newContact = new Contact(phoneNumber, fullName, fullName, fullName, fullName, dateOfBirth, email);
        listContacts.add(newContact);
        try {
            addDataToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean showContactList() {
        if (listContacts.size() == 0) {
            return false;
        }
        for (Contact ele : listContacts) {
            System.out.println(ele.toString());
            Inputer.inputString("Enter to continue");
        }
        return true;
    }

    public boolean editContact(int phoneNumber, String fullName, String group, String gender, String address, String dateOfbirth, String email){
        for (Contact ele : listContacts){
            if (ele.getPhoneNumber() == phoneNumber){
                ele = new Contact(phoneNumber,fullName,group,gender,address,dateOfbirth,email);
                ele.setFullName(fullName);
                ele.setGender(gender);
                ele.setAddress(address);
                ele.setDateOfbirth(dateOfbirth);
                ele.setGroup(group);
                ele.setEmail(email);
                showContactList();
                try {
                    addDataToFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public boolean deleteContact(int phoneNumber){
        for (Contact ele : listContacts){
            if (ele.getPhoneNumber() == phoneNumber){
                listContacts.remove(ele);
                try {
                    addDataToFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return true;
            }
        }
        return false;
    }
    public Contact searchContact(int phoneNumber){
        Contact contact = new Contact();
        for (Contact ele : listContacts){
            contact = ele;
        }
        return contact;
    }


    public void addDataToFile() throws IOException {
        FileOutputStream file = new FileOutputStream("data.txt");
        ObjectOutputStream os = new ObjectOutputStream(file);
        os.writeObject(listContacts);
        os.close();
        file.close();
    }


    public void getDataFromFile() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("data.txt");
        ObjectInputStream is = new ObjectInputStream(file);
        listContacts = (List<Contact>) is.readObject();
        is.close();
        file.close();
    }
}
