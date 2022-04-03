package com.doguhan.socialunity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Bitmap bitmap;
    FragmentDegistir fragmentDegistir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentDegistir = new FragmentDegistir(MainActivity.this);
        fragmentDegistir.degistirFragment(new GirisEkraniFragment());

    }


    //ALTAKI METHODLA BIRLIKTE KULLANICININ RESIM SECMESINI VE SAGLAR VE BLANK FRAGMENT  ICINDE GOSTERIR
    public void resimGoster() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        Log.i("resim", "1.");
        startActivityForResult(intent, 777);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("resim", "2.");
        if (requestCode == 777 && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                String resimKod=imageToString();
                fragmentDegistir = new FragmentDegistir(MainActivity.this);
                fragmentDegistir.veriGonder(new BlankFragment(), String.valueOf(resimKod));
              /*  fragmentDegistir = new FragmentDegistir(MainActivity.this);
                fragmentDegistir.veriGonder(new AnaEkranFragment(),String.valueOf(bitmap));*/

                //Log.i("resim", String.valueOf(bitmap));
                Log.i("resim2", String.valueOf(resimKod));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String imageToString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        String imageToString = Base64.encodeToString(bytes, Base64.DEFAULT);
        return imageToString;
    }


}