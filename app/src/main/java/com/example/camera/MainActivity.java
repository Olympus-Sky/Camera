package com.example.camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Photo();
    }

    private void Photo() {
        Button btnPhotoJ = (Button)findViewById(R.id.btnPhoto);

        btnPhotoJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ImageView imgPhotoJ = (ImageView)findViewById(R.id.imgPhoto);
        Bundle bundle = data.getExtras();

        if(data != null) {
            Bitmap bitmap = (Bitmap)bundle.get("data");
            imgPhotoJ.setImageBitmap(bitmap);
        }
    }
}
