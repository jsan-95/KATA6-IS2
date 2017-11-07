package kata4.main;

import java.io.IOException;
import java.util.ArrayList;
import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListReader;

public class Kata4 {

    public static void main(String[] args) throws IOException {
        String fileName = "/Users/Yisus95/NetBeansProjects/Kata4/src/emails.txt";
        ArrayList <Mail> mailList = MailListReader.read(fileName);
        Histogram histogram = MailHistogramBuilder.build(mailList);

        
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        
        
        
        histoDisplay.execute();
    }
}
