package fr.imt_atlantique.example.communication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;


public class MainActivity extends AppCompatActivity implements EditFragment.OnEditNameInterface {

    private EditFragment editFragment;
    private DisplayFragment displayFragment;

    private static final String PREFERENCE = "preference";
    private static final String Display_KEY = "display";
    private SharedPreferences sharedPreferences;

    /**
     * Static
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        editFragment =  (EditFragment) getSupportFragmentManager().findFragmentById(R.id.editFragment);
        displayFragment = (DisplayFragment) getSupportFragmentManager().findFragmentById(R.id.displayFragment);
        String displayText = sharedPreferences.getString(Display_KEY, "");
        onEditName(displayText);
    }


    @Override
    public void onEditName(String newName) {
        displayFragment.displayName(newName);
    }


    @Override
    protected void onStop() {
        saveData();
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveData();
    }


    private void saveData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Display_KEY, editFragment.getData().getText().toString());
        editor.apply();
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