package com.doguhan.socialunity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.doguhan.socialunity.Models.GirisModel;
import com.doguhan.socialunity.RestApi.ManagerAll;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GirisEkraniFragment extends Fragment {

    @BindView(R.id.girisEkraniKadiEditText)
    EditText girisEkraniKadiMailEditText;
    @BindView(R.id.girisEkraniSifreEditText)
    EditText girisEkraniSifreEditText;
    @BindView(R.id.girisEkraniGirisYapButon)
    Button girisEkraniGirisYapButon;
    @BindView(R.id.girisEkraniSifremiUnuttumText)
    TextView girisEkraniSifremiUnuttumText;
    @BindView(R.id.girisEkraniKaydolText)
    TextView girisEkraniKaydolText;


    View view;
    FragmentDegistir fragmentDegistir;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_giris_ekrani, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick(R.id.girisEkraniGirisYapButon)
    public void onGirisEkraniGirisYapButonClicked() {
        if(!girisEkraniKadiMailEditText.getText().toString().equals("") && !girisEkraniSifreEditText.getText().toString().equals("")){
            String kadi,ksifre;
            kadi = girisEkraniKadiMailEditText.getText().toString();
            ksifre = girisEkraniSifreEditText.getText().toString();

            girisYap(kadi,ksifre);

        }else{
            Toast.makeText(getContext(),"Lütfen tüm alanları doldurun",Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.girisEkraniSifremiUnuttumText)
    public void onGirisEkraniSifremiUnuttumTextClicked() {
    }


    @OnClick(R.id.girisEkraniKaydolText)
    public void onViewClicked() {
        fragmentDegistir = new FragmentDegistir(getContext());
        fragmentDegistir.degistirFragment(new KayitEkraniFragment());
    }
    public void girisYap(String kullanici_adi,String kullanici_sifre){
        Call<GirisModel> girisYap = ManagerAll.getInstance().girisYap(kullanici_adi,kullanici_sifre);
        girisYap.enqueue(new Callback<GirisModel>() {
            @Override
            public void onResponse(Call<GirisModel> call, Response<GirisModel> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getContext(),"Tebrikler başarıyla giriş yaptınız",Toast.LENGTH_SHORT).show();
                    fragmentDegistir = new FragmentDegistir(getContext());
                    fragmentDegistir.degistirFragment(new AnaEkranFragment());
                }
            }

            @Override
            public void onFailure(Call<GirisModel> call, Throwable t) {

            }
        });
    }
}