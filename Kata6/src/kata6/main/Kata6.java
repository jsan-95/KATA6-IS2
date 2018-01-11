package kata6.main;

import java.io.IOException;
import java.util.ArrayList;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {

    public static void main(String[] args) throws IOException, Exception {
        Kata6 kata6 = new Kata6();
        kata6.execute();
    }
    
    private ArrayList <Mail> mailList;
    private Histogram histogram;
    
    private void execute () throws Exception{
        input();
        process();    
        output();
    }

    private void input() throws IOException {
        String fileName = "/Users/Yisus95/NetBeansProjects/Kata4/src/emails.txt";
        mailList = MailListReader.read(fileName);
    }

    private void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }

    private void output() {
        new HistogramDisplay(histogram).execute();
    }
}
