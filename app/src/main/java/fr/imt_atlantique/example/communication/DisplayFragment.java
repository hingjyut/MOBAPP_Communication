package fr.imt_atlantique.example.communication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DisplayFragment extends Fragment {

    private TextView tvDisplayName;
    private View rootView;
    public static final String ARG_PARAM = "new name";
    protected String newName;



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            newName = getArguments().getString(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        rootView = inflater.inflate(R.layout.fragment_display, container, false);
        tvDisplayName = rootView.findViewById(R.id.tvDisplayName);
        System.out.println(newName);
        tvDisplayName.setText(newName);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public static DisplayFragment newInstance(String param){
        DisplayFragment displayFragment = new DisplayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM, param);
        displayFragment.setArguments(args);
        return displayFragment;
    }

}
