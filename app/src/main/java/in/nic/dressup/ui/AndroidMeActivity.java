package in.nic.dressup.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import in.nic.dressup.R;
import in.nic.dressup.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        if (savedInstanceState == null) {

            Bundle extras = getIntent().getExtras();
            headIndex = extras.getInt("headIndex");
            bodyIndex = extras.getInt("bodyIndex");
            legIndex = extras.getInt("legIndex");

            BodyPartFragment headFragment = new BodyPartFragment();
            BodyPartFragment bodyFragment = new BodyPartFragment();
            BodyPartFragment legFragment = new BodyPartFragment();

            headFragment.setmImageId(AndroidImageAssets.getHeads());
            headFragment.setmListIndex(headIndex);
            bodyFragment.setmImageId(AndroidImageAssets.getBodies());
            bodyFragment.setmListIndex(bodyIndex);
            legFragment.setmImageId(AndroidImageAssets.getLegs());
            legFragment.setmListIndex(legIndex);

            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .add(R.id.body_container, bodyFragment)
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }
    }
}