package com.doguhan.socialunity.RestApi;


import com.doguhan.socialunity.Models.AnaEkranGonderiler;
import com.doguhan.socialunity.Models.GirisModel;
import com.doguhan.socialunity.Models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RestApi {
    @FormUrlEncoded
    @POST("social_kayit_ol_bildirim.php")
    Call<Result> addUser (@Field("kullanici_adi") String kullanici_adi, @Field("kullanici_sifre") String kullanici_sifre,
                         @Field("kullanici_mail") String kullanici_mail, @Field("kullanici_ad_soyad") String kullanici_ad_soyad);

    @FormUrlEncoded
    @POST("social_kayit_ol_aktif_et.php")
    Call<Result> aktifEt(@Field("kullanici_mail") String kullanici_mail, @Field("kullanici_kod") String kullanici_kod);

    @FormUrlEncoded
    @POST("social_giris_yap.php")
    Call<GirisModel> girisYap(@Field("kullanici_adi") String kullanici_adi, @Field("kullanici_sifre") String kullanici_sifre);

    @GET("social_anaekran_tum_gonderiler.php")
    Call<List<AnaEkranGonderiler>> listele();

    @FormUrlEncoded
    @POST("resimekle.php")
    Call<Result> resimYukle(@Field("baslik") String baslik,@Field("image") String image);



}
