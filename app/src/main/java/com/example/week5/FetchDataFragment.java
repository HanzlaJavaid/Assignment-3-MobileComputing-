package com.example.week5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.week5.models.Result;
import com.example.week5.models.UserResponse;
import com.example.week5.networking.Appinterface;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FetchDataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FetchDataFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String phone;
    String name;
    String pic;
    public FetchDataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FetchDataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FetchDataFragment newInstance(String param1, String param2) {
        FetchDataFragment fragment = new FetchDataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fetch_data, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://randomuser.me/").addConverterFactory(GsonConverterFactory.create()).build();
        Appinterface service = retrofit.create(Appinterface.class);

        Call<UserResponse> call = service.getUsers();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response< UserResponse> response) {
                UserResponse data = response.body();
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);
                AllProfiles fragment = new AllProfiles();
                fragment.setArguments(bundle);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container,fragment);
                ft.commit();
                /*
                phone = response.body().getResults().get(0).getPhone();
                name = response.body().getResults().get(0).getName().getFirst();
                pic = response.body().getResults().get(0).getPicture().getLarge();
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putString("phone",phone);
                bundle.putString("picture",pic);
                //bundle.putString("phone",phone);
                ProfileFragment fragment = new ProfileFragment();
                fragment.setArguments(bundle);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container,fragment).addToBackStack(null);
                ft.commit();
                Log.v("",name);
                 */
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }
}