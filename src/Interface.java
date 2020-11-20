import java.io.*;

public class Interface {
    static int password =7917;

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("For Admin contol enter password. Else enter 0. To exit enter 11");
        int pass = Integer.parseInt(io.readLine());

        if (pass == 0) {
            System.out.println("Enter your User ID:");
            char id = (char) io.read();
            User obj = new User();
            obj.edit(id);
        } else if (pass == new Interface().password) {
            Admin obj = new Admin();
            obj.main();
        } else if(pass == 11)
            System.exit(0);
        else {
            System.out.println("wrong imput");
            try {//for delay
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            main(null);

        }
    }
}
