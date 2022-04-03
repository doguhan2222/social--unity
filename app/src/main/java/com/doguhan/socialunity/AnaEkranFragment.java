package com.doguhan.socialunity;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.doguhan.socialunity.Adapters.AnaEkranRecyclerviewAdapter;
import com.doguhan.socialunity.Models.AnaEkranGonderiler;
import com.doguhan.socialunity.Models.Result;
import com.doguhan.socialunity.RestApi.ManagerAll;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class AnaEkranFragment extends Fragment {


    View view;
    FragmentDegistir fragmentDegistir;
    RecyclerView anaEkranRecylerView;
    List<AnaEkranGonderiler> gonderilerList;
    AnaEkranRecyclerviewAdapter productAdapter;
    LinearLayoutManager linearLayoutManager;
    BottomNavigationView bottomNavigationView;
    ActivityResultLauncher activityResultLauncher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        view = inflater.inflate(R.layout.fragment_ana_ekran, container, false);

        anaEkranRecylerView = view.findViewById(R.id.anaEkranRecylerView);
        bottomNavigationView = view.findViewById(R.id.anaEkranNavigationBar);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.action1:
                        // ana ekrandaki recyclerview i yukarı en basa kaydiriyor
                        Toast.makeText(getContext(), "action1" + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        anaEkranRecylerView.smoothScrollToPosition(0);
                        break;
                    case R.id.action2:
                        //Resim yukleme ekranina gidiyor
                        ((MainActivity)getActivity()).resimGoster();
                        break;
                    case R.id.action3:
                        Toast.makeText(getContext(), "action3" + item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }

        });

        istekAt();
        return view;
    }




    // ANA EKRANDAKI GONDERILERI LISTELEYEN METHOD
    public void istekAt() {
        Call<List<AnaEkranGonderiler>> gonderiCek = ManagerAll.getInstance().goster();
        gonderiCek.enqueue(new Callback<List<AnaEkranGonderiler>>() {
            @Override
            public void onResponse(Call<List<AnaEkranGonderiler>> call, Response<List<AnaEkranGonderiler>> response) {
                gonderilerList = new ArrayList<>();
                gonderilerList = response.body();
                Log.i("deneme", gonderilerList.toString());

                //RECYCLERVIEW A ATAMA YAPIYOR
                productAdapter = new AnaEkranRecyclerviewAdapter(getContext(), (ArrayList<AnaEkranGonderiler>) gonderilerList);
                anaEkranRecylerView.setAdapter(productAdapter);

                linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                anaEkranRecylerView.setLayoutManager(linearLayoutManager);
            }
            @Override
            public void onFailure(Call<List<AnaEkranGonderiler>> call, Throwable t) {

            }
        });

    }

}

