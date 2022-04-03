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

public class KayitEkraniFragment extends Fragment {


    @BindView(R.id.kayitEkraniEpostaEditText)
    EditText kayitEkraniEpostaEditText;
    @BindView(R.id.kayitEkraniAdSoyadEditText)
    EditText kayitEkraniAdSoyadEditText;
    @BindView(R.id.kayitEkraniKadiEditText)
    EditText kayitEkraniKadiEditText;
    @BindView(R.id.kayitEkraniSifreEditText)
    EditText kayitEkraniSifreEditText;
    @BindView(R.id.kayitEkraniKayitTamamlaButon)
    Button kayitEkraniKayitTamamlaButon;
    @BindView(R.id.kayitEkraniHesapVarsaGirText)
    TextView kayitEkraniHesapVarsaGirText;

    View view;
    FragmentDegistir fragmentDegistir;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_kayit_ekrani, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.kayitEkraniKayitTamamlaButon)
    public void onKayitEkraniKayitTamamlaButonClicked() {

        if(!kayitEkraniEpostaEditText.getText().toString().equals("") && !kayitEkraniAdSoyadEditText.getText().toString().equals("") &&
           !kayitEkraniKadiEditText.getText().toString().equals("") && !kayitEkraniSifreEditText.getText().toString().equals("") ){
            String kmail,kadSoyad,kadi,ksifre;
            kmail = kayitEkraniEpostaEditText.getText().toString();
            kadSoyad = kayitEkraniAdSoyadEditText.getText().toString();
            kadi = kayitEkraniKadiEditText.getText().toString();
            ksifre = kayitEkraniSifreEditText.getText().toString();

            kayitOl(kadi,ksifre,kmail,kadSoyad);

        }else{
            Toast.makeText(getContext(),"Lütfen tüm alanları doldurun",Toast.LENGTH_SHORT).show();
        }

    }

    @OnClick(R.id.kayitEkraniHesapVarsaGirText)
    public void onKayitEkraniHesapVarsaGirTextClicked() {
        fragmentDegistir = new FragmentDegistir(getContext());
        fragmentDegistir.degistirFragment(new GirisEkraniFragment());
    }
    public void kayitOl(String kullaniciadi,String sifre,String mail, String adSoyad ){

        Call<Result> kayit = ManagerAll.getInstance().kayitOl(mail,adSoyad,kullaniciadi,sifre);
        kayit.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
        fragmentDegistir = new FragmentDegistir(getContext());
        fragmentDegistir.veriGonder(new KayitEkraniOnayFragment(),mail);
    }
}