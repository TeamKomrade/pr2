package com.example.pr2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EditImageMenuActivity extends AppCompatActivity {
    Bitmap selectedImage;
    ImageView editImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_image_menu);

        Init();
    }

    private void Init() {
        editImageView = findViewById(R.id.EditImageView);
        selectedImage = MainActivity.selectedImage;
        editImageView.setImageBitmap(selectedImage);
    }

    public void ImageRotate90(View view) {
        ImageRotate(90);
    }

    public void ImageRotate270(View view) {
        ImageRotate(270);
    }

    public void ImageReflectX(View view) {
        ImageReflect(-1, 1);
    }

    public void ImageReflectY(View view) {
        ImageReflect(1, -1);
    }

    private void EditImage(Matrix matrix, boolean filter) {
        selectedImage = Bitmap.createBitmap(selectedImage, 0,0, selectedImage.getWidth(), selectedImage.getHeight(), matrix, filter);
        editImageView.setImageBitmap(selectedImage);
    }

    private void ImageRotate(float degrees){
        Matrix matrix = new Matrix();
        matrix.setRotate(degrees);
        EditImage(matrix, false);
    }

    public void ImageReflect(float xmult, float ymult) {
        Matrix matrix = new Matrix();
        matrix.setScale(xmult, ymult);
        EditImage(matrix, true);
    }
}