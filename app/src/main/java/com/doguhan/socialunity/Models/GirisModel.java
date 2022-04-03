package com.doguhan.socialunity.Models;

public class GirisModel {
    // uygulamaya giris yapıldığında gelen respons u döndüren model class
    public String kullanici_id;
    public String kullanici_adi;
    public String kullanici_sifre;

    public String getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(String kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getKullanici_sifre() {
        return kullanici_sifre;
    }

    public void setKullanici_sifre(String kullanici_sifre) {
        this.kullanici_sifre = kullanici_sifre;
    }

    @Override
    public String toString() {
        return "GirisModel{" +
                "kullanici_id='" + kullanici_id + '\'' +
                ", kullanici_adi='" + kullanici_adi + '\'' +
                ", kullanici_sifre='" + kullanici_sifre + '\'' +
                '}';
    }
}
