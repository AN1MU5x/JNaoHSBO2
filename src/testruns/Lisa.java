package testruns;

/**
 * Created by Lisa on 04.04.2017.
 */
    import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

    public class Lisa {

        public static void main(String[] args) throws Exception {
            String robotUrl = "tcp://Emma.local:9559";
            // Create a new application
            Application application = new Application(args, robotUrl);
            // Start your application
            application.start();
            // Create an ALTextToSpeech object and link it to your current session
            ALTextToSpeech tts = new ALTextToSpeech(application.session());
            // Make your robot say something
            tts.say("Hello World!");
        }
    }

