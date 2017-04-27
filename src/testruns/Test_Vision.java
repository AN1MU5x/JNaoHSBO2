package testruns;

import com.aldebaran.qi.CallError;
import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.ALBarcodeReader;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALMovementDetection;
import utillities.Utts;

/**
 * Created by Lisa on 05.04.2017.
 */
public class Test_Vision {
    public static void main(String[] args) throws Exception {
        Utts.AppStart();
        System.out.println("Successfully connected to the robot");
        Test_Vision sensor = new Test_Vision();
        sensor.run(Utts.getAPP().session());
        Utts.getAPP().run();
    }

    ALMemory alMemory;
    ALBarcodeReader alBarcodeReader;
    boolean hilf= true;

    public void run(Session session) throws Exception {
        alMemory = new ALMemory(session);
        alBarcodeReader = new ALBarcodeReader(session);

        alBarcodeReader.subscribe("Test",10000,0.0f);
        alMemory.subscribeToEvent(
                "BarcodeReader/BarcodeDetected()", new EventCallback() {
                    @Override
                    public void onEvent(Object o) throws InterruptedException, CallError {
                        System.out.println("Barcode detected");
                    }
                });
    }

}