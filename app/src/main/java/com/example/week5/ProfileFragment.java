package com.example.week5;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.week5.models.UserResponse;
import com.squareup.picasso.Picasso;

import retrofit2.Call;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private  String picture;
    private String name;
    private String phone;
    TextView nameText;
    TextView phoneText;
    ImageView profilePic;
    Button nextButton;
    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(String name,String age) {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assert getArguments() != null;
        if(getArguments()!=null) {
            name = getArguments().getString("name");
            phone = getArguments().getString("phone");
            picture = getArguments().getString("picture");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        nameText = v.findViewById(R.id.name);
        nameText.setText(this.name);
        phoneText = v.findViewById(R.id.phone);
        phoneText.setText(this.phone);
        profilePic = v.findViewById(R.id.profilePic);
        Picasso.get().load(this.picture).into(profilePic);
        nextButton = v.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FetchDataFragment fragment = new FetchDataFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container,fragment).addToBackStack(null);
                ft.commit();
            }
        });
        return v;
    }
}