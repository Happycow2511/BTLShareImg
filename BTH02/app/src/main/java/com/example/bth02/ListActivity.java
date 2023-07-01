package com.example.bth02;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private RecyclerView rcvImg;
    private ListAdapter listAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homelist);

        rcvImg = findViewById(R.id.rcv_image);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this);
        rcvImg.setLayoutManager(linearLayoutManager);

        listAdapter = new ListAdapter(getListImg());
        rcvImg.setAdapter(listAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvImg.addItemDecoration(itemDecoration);
    }

    private List<ImgList> getListImg() {
        List<ImgList> list = new ArrayList<>();
        list.add(new ImgList(R.drawable.phuc1, "Phuc"));
        list.add(new ImgList(R.drawable.phuc2, "Phuc"));
        list.add(new ImgList(R.drawable.phuc3, "Phuc"));
        list.add(new ImgList(R.drawable.phuc4, "Phuc"));
        list.add(new ImgList(R.drawable.phuc5, "Phuc"));
        list.add(new ImgList(R.drawable.phuc1, "Phuc"));
        list.add(new ImgList(R.drawable.phuc2, "Phuc"));
        list.add(new ImgList(R.drawable.phuc3, "Phuc"));
        list.add(new ImgList(R.drawable.phuc4, "Phuc"));
        list.add(new ImgList(R.drawable.phuc5, "Phuc"));
        return  list;
    }
}
