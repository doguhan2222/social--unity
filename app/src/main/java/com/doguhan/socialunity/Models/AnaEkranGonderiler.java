package com.doguhan.socialunity.Models;

public class AnaEkranGonderiler {


    // ana ekrandaki recyclerview ın model class ı
    private String kid;
    private String kadi;
    private String kgonderiid;
    private String kprofilresmi;
    private String kgonderiresmi;

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public String getKadi() {
        return kadi;
    }

    public void setKadi(String kadi) {
        this.kadi = kadi;
    }

    public String getKgonderiid() {
        return kgonderiid;
    }

    public void setKgonderiid(String kgonderiid) {
        this.kgonderiid = kgonderiid;
    }

    public String getKprofilresmi() {
        return kprofilresmi;
    }

    public void setKprofilresmi(String kprofilresmi) {
        this.kprofilresmi = kprofilresmi;
    }

    public String getKgonderiresmi() {
        return kgonderiresmi;
    }

    public void setKgonderiresmi(String kgonderiresmi) {
        this.kgonderiresmi = kgonderiresmi;
    }

    @Override
    public String toString() {
        return "AnaEkranGonderiler{" +
                "kid='" + kid + '\'' +
                ", kadi='" + kadi + '\'' +
                ", kgonderiid='" + kgonderiid + '\'' +
                ", kprofilresmi='" + kprofilresmi + '\'' +
                ", kgonderiresmi='" + kgonderiresmi + '\'' +
                '}';
    }
}
