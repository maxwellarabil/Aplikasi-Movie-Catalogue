package com.example.emovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Detail extends AppCompatActivity {
    public static final String EXTRA_PERSON ="extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView tvObject = findViewById(R.id.txt_produser);
        TextView tvObject2 = findViewById(R.id.txt_sutradara);
        TextView tvObject3 = findViewById(R.id.txt_penulis);
        TextView tvObject4 = findViewById(R.id.txt_distribusi);
        TextView tvObject5 = findViewById(R.id.txt_tayang);
        TextView tvObject6 = findViewById(R.id.txt_durasi);
        TextView tvObject7 = findViewById(R.id.txt_genre);
        TextView tvObject8 = findViewById(R.id.txt_pemeran);
        TextView tvObject9 = findViewById(R.id.txt_cerpen);
        ImageView gambar = findViewById(R.id.img_picture);
        ImageView gambar2 = findViewById(R.id.img_genre);
        Button button = findViewById(R.id.btn_back);
        Button button2 = findViewById(R.id.btn_trailler);

        MovieData movie = getIntent().getParcelableExtra(EXTRA_PERSON);
        final String text = movie.getProduser();
        String text2 = movie.getSutradara();
        String text3 = movie.getPenulis();
        String text4 = movie.getDistribusi();
        String text5 = movie.getTayang();
        String text6 = movie.getDurasi();
        String text7 = movie.getTxtgenre();
        String text8 = movie.getPemeran();
        String text9 = movie.getKetSinopsis();
        final String text10 = movie.getLink();
        int img = movie.getPicture();
        int img2 = movie.getGenre();

        tvObject.setText(text);
        tvObject2.setText(text2);
        tvObject3.setText(text3);
        tvObject4.setText(text4);
        tvObject5.setText(text5);
        tvObject6.setText(text6);
        tvObject7.setText(text7);
        tvObject8.setText(text8);
        tvObject9.setText(text9);
        gambar.setImageResource(img);
        gambar2.setImageResource(img2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kembali = new Intent(Detail.this, MainActivity.class);
                startActivity(kembali);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(text10));
                startActivity(intent);
            }
        });
    }
}
