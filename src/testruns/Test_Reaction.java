package testruns;


import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALSpeechRecognition;
import utillities.Utts;


import java.util.ArrayList;


/**
 * Created by JNaoHSBO on 05.04.2017.
 */
public class Test_Reaction{

    private static ALSpeechRecognition alSpeechRecognition;

    public static void main(String[] args) throws Exception{
/*
        alSpeechRecognition.pause(true);
        alSpeechRecognition.setVocabulary(names, true);
        alSpeechRecognition.pause(false);
*/
        alSpeechRecognition = new ALSpeechRecognition(Utts.getAPP().session());

        Test_Reaction test_reaction = new Test_Reaction();

        test_reaction.run(Utts.getAPP().session());
        Utts.getAPP().run();
    }

    private long recID;
    private ALMemory memory;
    private ArrayList recWord = new ArrayList<String>();

    public void run(Session session) throws Exception {

        memory = new ALMemory(session);
        recID = memory.subscribeToEvent(
                "WordRecognized", arg0 -> {

                    alSpeechRecognition.pause(true);
                 //   alSpeechRecognition.setVocabulary(names, true);
                    //getting the last word
                    recWord = (ArrayList) memory.getData("WordRecognized");
                    System.out.println(recWord);
                    String name = (String)recWord.get(0);

                    if (name.charAt(0)=='<') {
                        // cut out <...> phrases
                        name = name.substring(name.indexOf('>') + 2, name.lastIndexOf('<') - 1);
                        System.out.println(name);
                    }

                    for (String m: Utts.getNames()) {
                        //Talk to known people
                        if(name.equals(m)&&!name.equals("do it")&&!name.equals("stop")&&(float)recWord.get(1)>0.5f){
                            try {
                                Utts.talk("Hello " + name + " I know You!");
                                Thread.sleep(20);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }


                    }if(name.equals("stop")&&(float)recWord.get(1)>0.3f){
                        try {
                            Utts.talk("OK i will stop!");
                            Thread.sleep(20);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        memory.unsubscribeToEvent(recID);
                        Utts.getAPP().stop();
                    }else if(name.equals("do it")&&(float)recWord.get(1)>0.5f) {
                        try {
                            Utts.talk("No, I will not!");
                            Thread.sleep(20);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    alSpeechRecognition.pause(false);
                });
    }
}
