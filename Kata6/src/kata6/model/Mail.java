package kata6.model;

public class Mail {
    private String mail;
    
    
    public Mail(String mail){
        this.mail = mail;
    } 
    
    
    public String getDomain(){
        if(mail.contains("@")){
            return mail.split("@")[1];
        }
        return "";
    }
    
    public String getMail() {
        return mail;
    }
}
