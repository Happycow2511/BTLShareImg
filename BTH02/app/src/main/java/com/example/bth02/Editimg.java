package com.example.bth02;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.request.RequestOptions;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import android.os.Bundle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.Instant;

public class Editimg extends AppCompatActivity {
    private static final int REQUEST_EDIT_IMAGE = 1;
    private ImageView imageView;
    private ImageButton imgbtnCrop;
    private ImageButton imgbtnFilter;
    int IMAGE_REQUEST_CODE=101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editimg);
//        imageView = findViewById(R.id.imageView);
        imgbtnCrop = findViewById(R.id.btnCrop);
        imgbtnFilter = findViewById(R.id.btnCamera);

        imgbtnCrop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult( intent, IMAGE_REQUEST_CODE);
            }
        });
        // Nhận Uri của ảnh từ Intent
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(requestCode == IMAGE_REQUEST_CODE){
//            if (data.getData() != null){
//                Uri filePath = data.getData();
//                Intent dsPhotoEditorIntent = new Intent(this, DsPhotoEditorActivity.class);
//
//                dsPhotoEditorIntent.setData(filePath);
//
//                dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY, "PhotoEditor");
//                int[] toolsToHide = {DsPhotoEditorActivity.TOOL_ORIENTATION, DsPhotoEditorActivity.TOOL_CROP};
//                dsPhotoEditorIntent.putExtra(DsPhotoEditorConstants.DS_PHOTO_EDITOR_TOOLS_TO_HIDE, toolsToHide);
//                startActivityForResult(dsPhotoEditorIntent, 200);
//            }
//        }
//    }
}