import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inputer {
    public Inputer() {
    }

    public  int inputInt(String message) {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        boolean check;
        System.out.println(message);
        do {
            try {
                value = Integer.parseInt(scanner.nextLine());
                check = false;
            } catch (NumberFormatException e) {
                System.out.println("Input error, please input a number!!!");
                check = true;
            }
        } while (check);
        return value;
    }

    public  String inputString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public  int inputPhoneNumber(String message){
        boolean isValid;
        String phoneValidate;
        do {
            phoneValidate = inputString(message);
            isValid = validate(phoneValidate,"^[0]\\d{9}$");
        } while (!isValid);
        return Integer.parseInt(phoneValidate);
    }

    public String inputEmail(String message){
        boolean isValid;
        String emailValidate;
        do {
            emailValidate = inputString(message);
            isValid = validate(emailValidate,"^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        } while (!isValid);
        return emailValidate;
    }

    public boolean validate(String value,String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
