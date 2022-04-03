package com.doguhan.socialunity.RestApi;



import com.doguhan.socialunity.Models.AnaEkranGonderiler;
import com.doguhan.socialunity.Models.GirisModel;
import com.doguhan.socialunity.Models.Result;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {


    private static ManagerAll ourInstance = new ManagerAll();
    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }
    public Call<Result> kayitOl (String mail, String adSoyad, String kullaniciadi,String sifre){
        Call<Result> x = getRestApi().addUser( kullaniciadi,sifre,mail,adSoyad);
        return x;
    }

    public Call<Result> aktifEt (String mailAdres, String code){
        Call<Result> y = getRestApi().aktifEt( mailAdres , code);
        return y;
    }

    public Call<GirisModel> girisYap (String kullanici_adi, String kullanici_sifre){
        Call<GirisModel> z = getRestApi().girisYap( kullanici_adi , kullanici_sifre);
        return z;
    }
    public Call<List<AnaEkranGonderiler>> goster (){
        Call<List<AnaEkranGonderiler>> v = getRestApi().listele();
        return v;
    }
    public Call<Result> resimYukle (String baslik, String image){
        Call<Result> k = getRestApi().resimYukle( baslik , image);
        return k;
    }



}
