
import java.io.*;

public class User {
    public void edit(char ID) throws IOException, InterruptedException {
        File file = new File("src//Attendance.txt");//Object holding the database file
        Interface obj = new Interface();

        BufferedReader br = new BufferedReader(new FileReader(file));//Objects for reading the database
        BufferedReader br2 = new BufferedReader(new FileReader(file));

        String read="",user="",store="",t1="";
        int k1;

        read = br.readLine();
        while (read != null) {
            if (read.indexOf(ID) != -1)
                user = read;
            read = br.readLine();
        }

        if (user == "") {
            System.out.println("ID not found");
            try {//for delay
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            obj.main(null);
        }

        t1 = user.substring(1);
        t1 = t1.trim();

        k1 = Integer.parseInt(t1);
        k1 += 1;

        t1 = Integer.toString(k1);
        user = user.substring(0,1)+" "+t1;

        read = br2.readLine();
        while (read != null) {
            if (read.indexOf(ID) >= 0)
                store = store + user + "\r\n";
            else
                store = store + read + "\r\n";
            read = br2.readLine();
        }

        br.close();
        br2.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file));//Object to write on the database
        bw.write(store);
        bw.close();
        System.out.println("DONE.Attendance added");

        try {//for delay
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        System.out.println("cleared");
        try {//for delay
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        obj.main(null);
    }
}
