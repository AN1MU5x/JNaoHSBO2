package vision;

import audio.WordRecognizedEvent;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.ALFaceDetection;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;
import motion.Position;
import utillities.Uts;

import java.util.ArrayList;

public class FaceDetectedEvent {

    private ALMemory alMemory;
    private ALTextToSpeech alTextToSpeech;
    private ALFaceDetection alFaceDetection;
    private long faceID = 0;
    private int i= 0;
    private boolean hilf1=true;

    public void run(Session session) throws Exception {
        alMemory = new ALMemory(session);
        alTextToSpeech = new ALTextToSpeech(session);
        alFaceDetection = new ALFaceDetection(session);

        alFaceDetection.subscribe("Face",1000,0.0f);
        faceID = alMemory.subscribeToEvent(
                "FaceDetected", new EventCallback() {
                    @Override
                    public void onEvent(Object o) throws InterruptedException, CallError {
                        System.out.println(i);
                        i++;
                        System.out.println("Face detected");
                        ArrayList faceDetected = (ArrayList) o;

                        if(faceDetected.size()>1) {
                            ArrayList faceInfoList = (ArrayList) (faceDetected.get(1));

                            if(faceInfoList.size() > 1){
                                ArrayList faceInfo = (ArrayList) (faceInfoList.get(0));
                                ArrayList extraInfo = (ArrayList) (faceInfo.get(1));
                                String faceLabel = (String) (extraInfo.get(2));
                                System.out.println(faceLabel);

                                //Wer bin ich
                                if (WordRecognizedEvent.iFunktion == 1&&i<=20) {
                                    if (faceLabel.equals("Koch") && hilf1) {
                                        hilf1 = false;
                                        alMemory.unsubscribeToEvent(faceID);
                                        alFaceDetection.unsubscribe("Face");
                                        alTextToSpeech.say("Herr " + faceLabel);
                                    }
                                    if (faceLabel.equals("Brabender") && hilf1) {
                                        hilf1 = false;
                                        alMemory.unsubscribeToEvent(faceID);
                                        alFaceDetection.unsubscribe("Face");
                                        alTextToSpeech.say("Frau " + faceLabel);
                                    }
                                    if (faceLabel.equals("Stefan") && hilf1 || faceLabel.equals("Iskar") && hilf1 || faceLabel.equals("Andi") && hilf1 || faceLabel.equals("Lisa") && hilf1) {
                                        hilf1 = false;
                                        alMemory.unsubscribeToEvent(faceID);
                                        alFaceDetection.unsubscribe("Face");
                                        alTextToSpeech.say(faceLabel);
                                    }
                                }
                                else if(WordRecognizedEvent.iFunktion == 1&&i>20){
                                    alMemory.unsubscribeToEvent(faceID);
                                    alFaceDetection.unsubscribe("Face");
                                    alTextToSpeech.say("Keine Ahnung");
                                }
                                //Hallo
                                else if (WordRecognizedEvent.iFunktion == 2&&i<=20) {
                                    if (faceLabel.equals("Koch") && hilf1) {
                                        hilf1 = false;
                                        alMemory.unsubscribeToEvent(faceID);
                                        alFaceDetection.unsubscribe("Face");
                                        alTextToSpeech.say("Hallo Herr " + faceLabel);
                                        try {
                                            Position.winken();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    }
                                    if (faceLabel.equals("Brabender") && hilf1) {
                                        hilf1 = false;
                                        alMemory.unsubscribeToEvent(faceID);
                                        alFaceDetection.unsubscribe("Face");
                                        alTextToSpeech.say("Hallo Frau " + faceLabel);
                                        try {
                                            Position.winken();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }

                                    }
                                    if (faceLabel.equals("Stefan") && hilf1 || faceLabel.equals("Iskar") && hilf1 || faceLabel.equals("Andi") && hilf1 || faceLabel.equals("Lisa") && hilf1) {
                                        hilf1 = false;
                                        alMemory.unsubscribeToEvent(faceID);
                                        alFaceDetection.unsubscribe("Face");
                                        alTextToSpeech.say("Hallo " + faceLabel);
                                        try {
                                            Position.winken();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                else if(WordRecognizedEvent.iFunktion == 2&&i>20){
                                    alMemory.unsubscribeToEvent(faceID);
                                    alFaceDetection.unsubscribe("Face");
                                    alTextToSpeech.say("Hallo");
                                }
                            }
                        }

                    }
                });
    }
}
