package com.doguhan.socialunity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class BlankFragment extends Fragment {

    @BindView(R.id.telefondan_secilen_resim_imageview)
    ImageView telefondanSecilenResimImageview;
    @BindView(R.id.resim_yukle_resim_baslik)
    EditText resimYukleResimBaslik;
    @BindView(R.id.button_kaydet)
    Button buttonKaydet;
    @BindView(R.id.button_iptal)
    Button buttonIptal;

    View view;
    String resim;
    String baslik;
    FragmentDegistir fragmentDegistir;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_blank, container, false);
        ButterKnife.bind(this, view);
        if (getArguments() != null) {
            // mainActivitydeki methoddan gelen resimin base64 kodu
            resim = getArguments().getString("veri").toString();
            Log.i("bit", resim);
            // imageview icinde resmi gosteriyor
            telefondanSecilenResimImageview.setImageBitmap(convertStringToBitmap(resim));
            telefondanSecilenResimImageview.setVisibility(View.VISIBLE);
        }
        return view;
    }

    public static Bitmap convertStringToBitmap(String string) {
        byte[] byteArray1;
        byteArray1 = Base64.decode(string, Base64.DEFAULT);
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray1, 0,
                byteArray1.length);/* w  w  w.ja va 2 s  .  c om*/
        return bmp;
    }


    @OnClick(R.id.button_kaydet)
    public void onButtonKaydetClicked() {
        baslik = resimYukleResimBaslik.getText().toString();
        resimYukle(baslik,resim);

    }


    @OnClick(R.id.button_iptal)
    public void onButtonIptalClicked() {
        fragmentDegistir = new FragmentDegistir(getContext());
        fragmentDegistir.degistirFragment(new AnaEkranFragment());
    }

    public void resimYukle(String baslik,String resim){
        Call<Result> resimGonder= ManagerAll.getInstance().resimYukle(baslik,resim);
        resimGonder.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.i("resimCall","fail1");
                if(response.body().getResult().equals("Resim Eklendi")){
                    Toast.makeText(getContext(),"Resminiz Yüklendi",Toast.LENGTH_SHORT).show();
                    fragmentDegistir = new FragmentDegistir(getContext());
                    fragmentDegistir.degistirFragment(new AnaEkranFragment());
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.i("resimCall","fail2");
            }
        });
        Log.i("resimCall","fai3");
    }


}