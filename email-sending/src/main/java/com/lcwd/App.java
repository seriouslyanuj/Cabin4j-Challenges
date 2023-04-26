

import com.concepts.email.GEmailSender;

public class App {
    public static void main(String[] args) {

        GEmailSender gEmailSender = new GEmailSender();
        String to = "sales@cabin4j.com";
        String from = "seriouslyanuj@gmail.com";
        String subject = "Challenge Completed";
        String text = "Name: Anuj Gupta\\nEmail: seriouslyanuj@gmail.com\\nMobile No.: 9170995081\\nBranch, Year, Department, & Roll No.: IT, 2nd Year, B.Tech, Roll No. 2100290130034\\n";
        boolean b = gEmailSender.sendEmail(to, from, subject, text);
        if (b) {
            System.out.println("Email is sent successfully");
        } else {
            System.out.println("There is problem in sending email");
        }

    }
}
