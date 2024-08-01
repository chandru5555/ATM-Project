import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    HashMap<Integer, Integer> data = new HashMap<>();

    protected void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(952141, 191904);
                data.put(989947, 71976);

                System.out.println("WELCOME TO ATM PROJECT");
                System.out.println("ENTER YOUR CUSTOMER NUMBER");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("ENTER YOUR PIN NUMBER");
                setPinNumber(menuInput.nextInt());

                int cn = getCustomerNumber();
                int pn = getPinNumber();

                if (data.containsKey(cn) && data.get(cn) == pn) {
                    getAccountType();
                } else {
                    System.out.println("\nWRONG CUSTOMER NUMBER OR PIN NUMBER\n");
                }
            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Only numbers are allowed.\n");
                //x = 2;
            }
        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("SELECT THE ACCOUNT YOU WANT TO ACCESS:");
        System.out.println("TYPE 1: CHECKING ACCOUNT");
        System.out.println("TYPE 2: SAVING ACCOUNT");
        System.out.println("TYPE 3: EXIT");

        int selection = menuInput.nextInt();
        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("THANK YOU FOR USING OUR ATM");
                break;
            default:
                System.out.println("\nINVALID CHOICE\n");
                getAccountType();
                break;
        }
    }

    public void getChecking() {
        System.out.println("CHECKING ACCOUNT");
        System.out.println("TYPE 1: VIEW BALANCE");
        System.out.println("TYPE 2: WITHDRAW FUNDS");
        System.out.println("TYPE 3: DEPOSIT FUNDS");
        System.out.println("TYPE 4: EXIT");
        System.out.println("CHOICE: ");

        int selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                System.out.println("CHECKING ACCOUNT BALANCE: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("THANK YOU FOR USING OUR ATM");
                break;
            default:
                System.out.println("\nINVALID CHOICE\n");
                getChecking();
                break;
        }
    }

    public void getSaving() {
        System.out.println("SAVING ACCOUNT");
        System.out.println("TYPE 1: VIEW BALANCE");
        System.out.println("TYPE 2: WITHDRAW FUNDS");
        System.out.println("TYPE 3: DEPOSIT FUNDS");
        System.out.println("TYPE 4: EXIT");
        System.out.println("CHOICE: ");

        int selection = menuInput.nextInt();
        switch (selection) {
            case 1:
                System.out.println("SAVING ACCOUNT BALANCE: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("THANK YOU FOR USING OUR ATM");
                break;
            default:
                System.out.println("\nINVALID CHOICE\n");
                getSaving();
                break;
        }
    }
}
