package fr.imt_atlantique.example.communication;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


public class EditFragment extends Fragment {
    private View rootView;
    private Button button;
    private EditText newNameEt;
    private OnEditNameInterface mainActivity;
//    private String savedName;

    public interface OnEditNameInterface{
        void onEditName(String newName);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        mainActivity = (OnEditNameInterface) activity;
        System.out.println("EditFragment, OnAttach");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_edit, container, false);
        button = rootView.findViewById(R.id.buttonActionDisplay);
        newNameEt = (EditText) rootView.findViewById(R.id.editName);
        return rootView;
    }

    public void setNewName(String name){
        newNameEt.setText(name);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState ){
        if (button!=null){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainActivity.onEditName(newNameEt.getText().toString());
                }
            });
        }
    }
}
