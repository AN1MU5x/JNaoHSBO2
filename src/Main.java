//Klasse für die Spracherkennung
import audio.WordRecognizedEvent;
//Klasse für verschiedene kleine Methoden wie z.B. AppStart();
import javafx.stage.Stage;
import utillities.Surface_Thread;
import utillities.User_Surface_1;
import utillities.Uts;

public class Main{
    public static void main(String[] args) throws Exception {

        Uts.AppStart();

        //Applikation wird gestartet
        System.out.println("Successfully connected to the robot");
        //Starten der Spracherkennung
        WordRecognizedEvent wordRecognizedEvent = new WordRecognizedEvent();
        wordRecognizedEvent.run(Uts.getAPP().session());
        Uts.getAPP().run();

    }
}
