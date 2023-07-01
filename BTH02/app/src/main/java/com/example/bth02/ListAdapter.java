package com.example.bth02;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private List<ImgList> ListImg;

    public ListAdapter(List<ImgList> listImg) {
        this.ListImg = listImg;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_image_list, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        ImgList imgList = ListImg.get(position);
        if ( imgList ==  null){
            return;
        }
        holder.imgUser.setImageResource(imgList.getImage());
        holder.tvName.setText(imgList.getName());

    }

    @Override
    public int getItemCount() {
        if (ListImg != null){
            return ListImg.size();
        }
        return 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView imgUser;
        private TextView tvName;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgUser =itemView.findViewById(R.id.img_user);
            tvName =itemView.findViewById(R.id.tv_name);
        }
    }
}
