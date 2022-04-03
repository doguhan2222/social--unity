package com.doguhan.socialunity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.doguhan.socialunity.Models.Result;
import com.doguhan.socialunity.RestApi.ManagerAll;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KayitEkraniOnayFragment extends Fragment {


    @BindView(R.id.kayitAktifEtMailText)
    TextView kayitAktifEtMailText;
    @BindView(R.id.kayitEkraniKodEditText)
    EditText kayitEkraniKodEditText;
    @BindView(R.id.kayitEkraniKayitTamamlaButon)
    Button kayitEkraniKayitTamamlaButon;

    View view;
    FragmentDegistir fragmentDegistir;


    String gelenMail ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_kayit_ekrani_onay, container, false);
        ButterKnife.bind(this, view);
        //ONAY EKRANINA GECERKEN TEXTVIEW A VERI ATAMAK ICIN ONCEKI FRAGMENTEN VERI ALAN METHO
        if (getArguments() != null) {
            gelenMail = getArguments().getString("veri").toString();
            kayitAktifEtMailText.setText(gelenMail);
        }
        return view;
    }

    @OnClick(R.id.kayitEkraniKayitTamamlaButon)
    public void onViewClicked() {
        String kod;
        kod = kayitEkraniKodEditText.getText().toString();
        aktiflestir(gelenMail, kod);
    }

    public void aktiflestir(String mail, String code) {
        Call<Result> aktifET = ManagerAll.getInstance().aktifEt(mail,code);
        aktifET.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.body().getResult().equals("ONAY BASARILI...")){
                    fragmentDegistir = new FragmentDegistir(getContext());
                    fragmentDegistir.degistirFragment(new GirisEkraniFragment());
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

    }
}