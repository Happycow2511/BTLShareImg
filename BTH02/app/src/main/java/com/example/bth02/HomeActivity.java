package com.example.bth02;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class HomeActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    private Button btnUp;
    private Button btnShare;
    private ImageView imageView;

    private Uri selectedImageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnUp = findViewById(R.id.btnUp);
        btnShare = findViewById(R.id.btnShare);
        imageView = findViewById(R.id.imageView);

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ListActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareImage();
            }
        });
    }


    private void shareImage() {
        // Kiểm tra xem ImageView có ảnh đang hiển thị hay không
        if (imageView.getDrawable() == null) {
            Toast.makeText(this, "No Image", Toast.LENGTH_SHORT).show();
            return;
        }

        // Lấy ảnh từ ImageView
        BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        // Lưu ảnh vào bộ nhớ cache của ứng dụng
        File cachePath = new File(getExternalCacheDir(), "image.jpg");
        try {
            FileOutputStream outputStream = new FileOutputStream(cachePath);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Tạo Intent chia sẻ
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(cachePath));

        // Mở ứng dụng SMS mặc định và chia sẻ ảnh
        startActivity(Intent.createChooser(intent, "Share by SMS"));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String selectedImage = data.getStringExtra("image");
            if (selectedImage != null) {
                Glide.with(this).load(selectedImage).into(imageView);
            }
        }
    }
}
