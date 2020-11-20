
import java.io.*;
public class Admin{

    File emp_file=new File("src//Employees.txt");//Objects holding the database files
    File att_file=new File("src//Attendance.txt");
    static BufferedReader IO=new BufferedReader(new InputStreamReader(System.in));

    public void main()throws IOException, InterruptedException{

        System.out.println("Enter 1 to see Employee database\nEnter 2 for exclusive editing of attendance\nEnter 3 to reset Monthly attendance\n*To go back to user mode press 4\n* To Exit press 0");

        int in=Integer.parseInt(IO.readLine());

        Admin ad=new Admin();
        if(in==1) ad.details();
        else if (in==2) ad.att_edit();
        else if (in==3) ad.reset();
        else if (in==4){
                Interface obj = new Interface();
                obj.main(null);
        }
        else if(in==0)
                System.exit(1);
    }

    public void details() throws IOException, InterruptedException {

            System.out.println("Enter employee code to view his details");
            char id = (char) IO.read();

            BufferedReader br = new BufferedReader(new FileReader(emp_file));
            String read = "", line = "", name = "", age = "";

            read = br.readLine();
            while (read != null) {
                    if (read.indexOf(id) == 0) {
                            line = read;
                            break;
                    }
                    read = br.readLine();
            }

            line = line.substring(1);
            line = line.trim();

            for (int i = 0; i < line.length(); i++) {
                    char k = line.charAt(i);
                    if (k >= 48 && k <= 57) {
                            age = Integer.toString(line.indexOf(k));
                            break;
                    }
            }

            name = line.substring(0, Integer.parseInt(age));
            name = name.trim();
            age = line.substring(Integer.parseInt(age));

            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            br.close();

            try {//for delay
                    Thread.sleep(2000);
            } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
            }

            System.out.println("Press 1 to continue");
            IO.readLine();

            int q = Integer.parseInt(IO.readLine());
            if (q == 1) main();

    }

    public void att_edit() throws IOException, InterruptedException {

            BufferedReader br = new BufferedReader(new FileReader(att_file));
            System.out.println("Enter employee id");
            char id = (char) IO.read();

            IO.readLine();
            System.out.println("Enter the correct attendance of employee till today");

            String att = IO.readLine();
            String store = "", read = "";
            boolean flag = false;
            read = br.readLine();
            while (read == null) {
                    if (read.indexOf(id) >= 0) {
                            store = store + id + "" + att + "\r\n";
                            flag = true;
                    } else store = store + read + "\r\n";
                    read = br.readLine();
            }

            if (flag == true) {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(att_file));
                    bw.write(store);
                    System.out.println("Done");
                    bw.close();
            } else System.out.println("ID not found");
            br.close();

            try {//for delay
                    Thread.sleep(1000);
            } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
            }

            System.out.println("Press 1 to continue");
            int q = Integer.parseInt(IO.readLine());
            if (q == 1) main();
    }

    public void reset()throws IOException, InterruptedException {

            BufferedReader br = new BufferedReader(new FileReader(att_file));
            String store = "", read = "";
            read = br.readLine();

            while (read != null) {
                    char x = read.charAt(0);
                    store = store + x + " " + "O\r\n";
                    read = br.readLine();
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(att_file));
            bw.write(store);
            br.close();
            bw.close();

            System.out.println("Reset in Progress........");
            try {//for delay
                    Thread.sleep(2000);
                    System.out.println("Done");
                    Thread.sleep(1000);
            } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
            }
            main();
    }
}


