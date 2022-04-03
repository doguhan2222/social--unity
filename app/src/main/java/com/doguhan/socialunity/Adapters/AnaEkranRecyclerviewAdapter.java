package com.doguhan.socialunity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.doguhan.socialunity.Models.AnaEkranGonderiler;
import com.doguhan.socialunity.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class AnaEkranRecyclerviewAdapter extends RecyclerView.Adapter<AnaEkranRecyclerviewAdapter.MyViewHolder> {
    ArrayList<AnaEkranGonderiler> mProductList;
    LayoutInflater inflater;
    Context CContext;

    public AnaEkranRecyclerviewAdapter(Context context, ArrayList<AnaEkranGonderiler> products) {
        inflater = LayoutInflater.from(context);
        this.mProductList = products;
        CContext=context;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.ana_ekran_recyclerview_items, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AnaEkranGonderiler selectedProduct = mProductList.get(position);
        holder.setData(selectedProduct, position);

    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView anaEkranGonderiKullaniciId;
        ImageView anaEkranGonderiResim,anaEkranGonderiProfilResim;


        public MyViewHolder(View itemView) {
            super(itemView);
            anaEkranGonderiKullaniciId = (TextView) itemView.findViewById(R.id.anaEkranGonderiKullaniciId);
            anaEkranGonderiResim = (ImageView) itemView.findViewById(R.id.anaEkranGonderiResim);
            anaEkranGonderiProfilResim = (ImageView) itemView.findViewById(R.id.anaEkranGonderiProfilResim);

        }

        //gelen modelden veri çekip view lara atıyor.
        public void setData(AnaEkranGonderiler selectedProduct, int position) {
            this.anaEkranGonderiKullaniciId.setText(selectedProduct.getKadi());
            Picasso.get().load("https://androidstudio2222.000webhostapp.com/resimler/"+mProductList.get(position).getKgonderiresmi()).into(this.anaEkranGonderiResim);
            Picasso.get().load("https://androidstudio2222.000webhostapp.com/resimler/"+mProductList.get(position).getKprofilresmi()).into(this.anaEkranGonderiProfilResim);


        }


        @Override
        public void onClick(View v) {


        }


    }
}
