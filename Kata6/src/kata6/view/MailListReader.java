
package kata6.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import kata6.model.Mail;


public class MailListReader {
    
    public static ArrayList<Mail> read(String fileName) throws FileNotFoundException, IOException{
        ArrayList<Mail> mailList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String mail = "";
        while((mail = reader.readLine()) != null){
            if(mail.contains("@")){
                mailList.add(new Mail(mail));
            }
        }
        return mailList;
    }
}
