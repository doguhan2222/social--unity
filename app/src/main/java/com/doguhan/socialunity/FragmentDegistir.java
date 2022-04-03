package com.doguhan.socialunity;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class FragmentDegistir {
    public FragmentDegistir(Context context) {
        this.context = context;
    }

    Context context;
    // YENI FRAGMENTE GECIS METHODU
    public void degistirFragment (Fragment fragment){
        ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()

                .replace(R.id.mainFrameLayout,fragment,"fragment")
                .commit();
    }
    // YENI FRAGMENTE GECIS YAPARKEN VERI GONDEREN METHOD
    public void veriGonder (Fragment fragment,String veri){
        Bundle bundle = new Bundle();
        bundle.putString("veri",veri);
        fragment.setArguments(bundle);
        ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()

                .replace(R.id.mainFrameLayout,fragment,"fragment")
                .commit();
    }
    public void veriGonder2 (Fragment fragment,String veri,String veri2){
        Bundle bundle = new Bundle();
        bundle.putString("veri1",veri);
        bundle.putString("veri2",veri2);
        fragment.setArguments(bundle);
        ((FragmentActivity)context).getSupportFragmentManager().beginTransaction()

                .replace(R.id.mainFrameLayout,fragment,"fragment")
                .commit();
    }
}
