
package kata6.view;


import java.util.ArrayList;
import java.util.function.Consumer;
import kata6.model.Histogram;
import kata6.model.Mail;


public class MailHistogramBuilder {

    public MailHistogramBuilder() {
    }
    
    public static Histogram<String> build(ArrayList<Mail> mail){
        Histogram <String> histo = new Histogram<>();
        mail.forEach((mail1) -> {
            histo.increment(mail1.getDomain(), 1);
        });
        return histo;
        
    }
}
