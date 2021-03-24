package com.example.week5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.example.week5.models.Result;
import com.example.week5.models.UserResponse;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AllProfiles#newInstance} factory method to
 * create an instance of this fragment.
 */


public class AllProfiles extends Fragment {

    private RecyclerView recyclerView;
    private UserResponse data;
    private String[] names;
    private String[] pics;
    public AllProfiles() {

        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static AllProfiles newInstance() {
        AllProfiles fragment = new AllProfiles();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null) {
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_profiles, container, false);
        /*Bundle bundle = this.getArguments();
        assert bundle != null;
        data = (UserResponse) bundle.getSerializable("data");
        assert data != null;
        String[] toSend = {data.getResults().get(0).getName().getFirst(),"Ali"};
        //toSend = (String[]) names.toArray();

        // Add the following lines to create RecyclerView
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new ProfileAdapter(toSend));*/
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();
        assert bundle != null;
        data = (UserResponse) bundle.getSerializable("data");
        assert data != null;
        names = new String[15];
        pics = new String[15];
        for(int i = 0; i < 15;i = i+1){
           names[i] = data.getResults().get(i).getName().getFirst();
           pics[i] = data.getResults().get(i).getPicture().getLarge();
        }
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new ProfileAdapter(names,pics));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * Generates Strings for RecyclerView's adapter. This data would usually come
     * from a local content provider or remote server.
     */
}