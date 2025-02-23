//import java.io.ObjectInputFilter.Config;
import java.net.URI;
//import javax.naming.directory.SearchResult;
import java.awt.Desktop;
import edu.cmu.sphinx.api.*;

public class project {
        
    public static void main(String[] args) throws Exception {
        Configuration config = new Configuration();
        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
        config.setDictionaryPath("src\\dic.dic");
        config.setLanguageModelPath("src\\lm.lm");
         try {
            LiveSpeechRecognizer rec = new LiveSpeechRecognizer(config);
            rec.startRecognition(true);
            Desktop desk = Desktop.getDesktop();
            while (rec.getResult() != null) {
                String result = rec.getResult().getHypothesis();
                if (result.toLowerCase().equals("google drive")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("http://drive.google.com/");
                    desk.browse(uri);
                }else if(result.toLowerCase().equals("whatsapp")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("http://whatsapp.com/");
                    desk.browse(uri);
                }else if(result.toLowerCase().equals("facebook")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("http://facebook.com/");
                    desk.browse(uri);
                }else if(result.toLowerCase().equals("chatgpt")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("http://chat.openai.com/");
                    desk.browse(uri);
                }else if(result.toLowerCase().equals("instagram")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("http://instagram.com/");
                    desk.browse(uri);
                }else if(result.toLowerCase().equals("google meet")){
                    System.out.println("Opening: "+result);
                    URI uri = new URI("http://meet.google.com/");
                    desk.browse(uri);
                }
                
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}