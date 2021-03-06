package com.marlonncarvalhosa.mamaeeuquero.adapter;

import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.marlonncarvalhosa.mamaeeuquero.R;
import com.marlonncarvalhosa.mamaeeuquero.model.Produto;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder> {
    private FragmentActivity activity;
    private List<Produto> produtos;
    private LinearLayout linearLayout;

    public ProdutoAdapter(FragmentActivity activity, List<Produto> produtos){
        this.activity=activity;
        this.produtos=produtos;
    }

    public void atualiza(List<Produto> produtos){
        this.produtos=produtos;
        this.notifyDataSetChanged();

    }

    @NonNull
    @Override
    public ProdutoAdapter.ViewHolder  onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProdutoAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_produto,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ProdutoAdapter.ViewHolder holder, int position) {
        final Produto produto = produtos.get(position);
        holder.textViewProduto.setText(produto.getNome());
        holder.textViewCidade.setText(produto.getLocal());
        holder.textViewPreco.setText(produto.getPreco());
        holder.data.setText(produto.getDataInicial());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        try {
            Glide.with(activity).load(produto.getImageUrl()).apply(RequestOptions.circleCropTransform()).into(holder.imageView);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewProduto,textViewPreco,textViewCidade,data;
        private ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            textViewProduto=itemView.findViewById(R.id.nomeProduto);
            textViewCidade=itemView.findViewById(R.id.cidade);
            textViewPreco=itemView.findViewById(R.id.preco);
            imageView = itemView.findViewById(R.id.imagemProduto);
            data=itemView.findViewById(R.id.datainicio);         }
    }
}