package fr.imt_atlantique.example.communication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Display;


public class MainActivity extends AppCompatActivity implements EditFragment.OnEditNameInterface {

    private EditFragment editFragment;
    private DisplayFragment displayFragment;
    static boolean portrait;


    /**
     * Static
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void onEditName(String newName) {
        displayFragment = (DisplayFragment) getSupportFragmentManager().findFragmentById(R.id.displayFragment);
        displayFragment.displayName(newName);
    }


    /**
     *  Dynamic
     *
     */


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        if (savedInstanceState==null){
//            portrait = true;
//        }
//
//        if(portrait){
//            editFragment = new EditFragment();
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, editFragment).commit();
//        }else{
//            displayFragment =  new DisplayFragment();
//            getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainer, displayFragment).commit();
//        }
//    }
//
//
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        portrait = !portrait;
//    }
//
//    @Override
//    public void onEditName(String newName) {
//        if (portrait){
//            displayFragment = DisplayFragment.newInstance(newName);
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            // replace editFragment by displayFragment, so the app shows display's layout
//            fragmentTransaction.replace(R.id.fragmentContainer, displayFragment);
//            fragmentTransaction.addToBackStack(editFragment.getClass().toString()).commit();
//        }else{
//            displayFragment.displayName(newName);
//        }
//    }
}