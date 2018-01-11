package kata6.main;

import java.io.IOException;
import java.util.ArrayList;
import kata6.Attribute;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramBuilder;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {
    
    
    
    public static void main(String[] args) throws IOException, Exception {
        Kata6 kata6 = new Kata6();
        kata6.execute();
    }
    
    private Histogram<String> dominios;
    private Histogram<Character> caracter;
    private ArrayList <Mail> mailList;
    private ArrayList <String> mailListDominios;
    private Histogram histogram;
    
    private void execute () throws Exception{
        input();
        process();    
        output();
    }

    private void input() throws IOException {
        String fileName = "/Users/Yisus95/NetBeansProjects/KATA4-IS2/Kata6/src/emails.txt";
        mailList = MailListReader.read(fileName);
        
    }

    private void process() {
        histogram = MailHistogramBuilder.build(mailList);

        HistogramBuilder<Mail> builder = new HistogramBuilder<>(mailList);
        
        dominios = builder.build(new Attribute<Mail,String>(){
            @Override
            public String get(Mail item){
                return item.getMail().split("@")[1];
            }
        });
        
        caracter = builder.build(new Attribute<Mail,Character>(){
            @Override
            public Character get(Mail item){
                return item.getMail().charAt(0);
            }
        });
        
    }

    private void output() {
        new HistogramDisplay(histogram).execute();
        new HistogramDisplay(dominios).execute();
        new HistogramDisplay(caracter).execute();
    }
}
