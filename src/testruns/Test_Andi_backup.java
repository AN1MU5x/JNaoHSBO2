package testruns;

import com.aldebaran.qi.helper.proxies.ALMotion;
import utillities.Utts;

import java.util.ArrayList;

/**
 * Created by Daniel on 24.04.2017.
 */
public class Test_Andi_backup {/*


import com.aldebaran.qi.helper.proxies.ALMotion;
import movings_Andi_Iskar.Position;
import utillities.Utts;

import java.util.ArrayList;


/**
 * Created by Andi on 19.04.2017.
 *//*
    public class Test_mov_bew_Andi {
        public static void main(String[] args) throws Exception {
            Utts.AppStart();


            ALMotion bew =new ALMotion(Utts.getSESSION());

            ArrayList name =new ArrayList<String>();
            ArrayList name1 =new ArrayList<String>();
            ArrayList name2 =new ArrayList<String>();
            ArrayList name3 =new ArrayList<String>();
            ArrayList name4 =new ArrayList<String>();

            ArrayList angles =new ArrayList<Float>();
            ArrayList angles1 =new ArrayList<Float>();
            ArrayList angles2 =new ArrayList<Float>();
            ArrayList angles3 =new ArrayList<Float>();
            ArrayList angles4 =new ArrayList<Float>();

            ArrayList time =new ArrayList<Float>();
            ArrayList time1 =new ArrayList<Float>();
            ArrayList time2 =new ArrayList<Float>();
            ArrayList time3 =new ArrayList<Float>();
            ArrayList time4 =new ArrayList<Float>();

            //hinzufügen bewegungsaktionen zur liste
            name.add(0,"LHipRoll");
            name.add(1,"RHipRoll");

            name1.add(0,"LKneePitch");
            name1.add(1,"RKneePitch");
            name1.add(2,"LHipPitch");
            name1.add(3,"RHipPitch");
            name1.add(4,"LAnklePitch");
            name1.add(5,"RAnklePitch");

            name2.add(0,"LHipRoll");
            name2.add(1,"RHipRoll");

            //name3.add(0,"RShoulderPitch");
            // name3.add(1,"LShoulderPitch");
            name3.add(0,"RHipRoll");
            name3.add(1,"LHipRoll");
            name3.add(2,"LHipPitch");

            //neu
            name3.add(3,"LShoulderPitch");

            name4.add(0,"RAnklePitch");
            name4.add(1,"RHipRoll");
            name4.add(2,"LHipRoll");
            name4.add(3,"LHipPitch");

            // name1.add(0,"RShoulderRoll");
            //festlegen der Aktionswinkel in liste

            angles.add(0,Utts.DegToRad(-5));
            angles.add(1,Utts.DegToRad(5));

            angles1.add(0,Utts.DegToRad(10));
            angles1.add(1,Utts.DegToRad(10));
            angles1.add(2,Utts.DegToRad(10));
            angles1.add(3,Utts.DegToRad(10));
            angles1.add(4,Utts.DegToRad(-10));
            angles1.add(5,Utts.DegToRad(-10));

            angles2.add(0,Utts.DegToRad(10));
            angles2.add(1,Utts.DegToRad(10));

            //   angles3.add(0,Utts.DegToRad(-10));
            //  angles3.add(1,Utts.DegToRad(-10));
            angles3.add(0,Utts.DegToRad(13));
            angles3.add(1,Utts.DegToRad(10));
            angles3.add(2,Utts.DegToRad(-35));
            angles3.add(3,Utts.DegToRad(0));

            angles4.add(0,Utts.DegToRad(-10));
            angles4.add(1,Utts.DegToRad(13));
            angles4.add(2,Utts.DegToRad(10));
            angles4.add(3,Utts.DegToRad(-35));

            //festlegen der Zeitpunkte der Aktionen
            time.add(0,2.f);
            time.add(1,2.f);

            time1.add(0,5.4f);
            time1.add(1,5.4f);
            time1.add(2,5.4f);
            time1.add(3,5.4f);
            time1.add(4,5.4f);
            time1.add(5,5.4f);

            time2.add(0,3.0f);
            time2.add(1,3.0f);

            //  time3.add(0,5f);
            // time3.add(1,5f);
            time3.add(0,7f);
            time3.add(1,7f);
            time3.add(2,7f);
            time3.add(3,7f);

            time4.add(0,5.f);
            time4.add(0,5.f);
            time4.add(0,5.f);
            time4.add(0,5.f);

            bew.setStiffnesses("LLeg",1.0f);
            bew.setStiffnesses("RLeg",1.0f);
            //  bew.setStiffnesses("RAnklePitch",0.0f);
            // bew.setStiffnesses("RKneePitch",0.0f);
            bew.setStiffnesses("LAnkleRoll",0.0f);
            bew.setStiffnesses("RAnkleRoll",0.0f);
            bew.angleInterpolation(name,angles,time,true);
            bew.setStiffnesses("LAnkleRoll",0.0f);
            bew.setStiffnesses("RAnkleRoll",0.0f);

            // bew.setStiffnesses("RHipRoll",0.0f);

            // bew.angleInterpolation(name1,angles1,time1,true);

            bew.setStiffnesses("LAnkleRoll",0.0f);
            bew.angleInterpolation(name2,angles2,time2,true);
            bew.setStiffnesses("LAnkleRoll",1.0f);

            //bew.setStiffnesses("RHipRoll",1.0f);
            //bew.setStiffnesses("RHipPitch",1.0f);

            bew.setStiffnesses("RAnkleRoll",1.0f);
            // bew.setStiffnesses("RAnklePitch",1.0f);
            // bew.setStiffnesses("LAnkleRoll",0.0f);
            // bew.setStiffnesses("LAnklePitch",0.0f);
            bew.setStiffnesses("LKneePitch",0.0f);
            bew.angleInterpolation(name3,angles3,time3,true);
            //bew.setStiffnesses("LKneePitch",1.0f);


            //  bew.setStiffnesses("LAnkleRoll",0.0f);
            // bew.setStiffnesses("LAnklePitch",0.0f);
            //bew.angleInterpolation(name4,angles4,time4,true);
            // bew.setStiffnesses("LAnkleRoll",1.0f);
            //   bew.setStiffnesses("LAnklePitch",1.0f);


            Thread.sleep(10000);
            System.out.println("Ende");

        }

    }


*/
}
