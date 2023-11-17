package com.example.emovie;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MovieAdapter adapter;
    private String[] dataName;
    private String[] dataSinopsis;
    private String[] dataProduser;
    private String[] dataSutradara;
    private String[] dataPenulis;
    private String[] dataDistribusi;
    private String[] dataTayang;
    private String[] dataDurasi;
    private String[] dataTxtgenre;
    private String[] dataPemeran;
    private String[] dataKetsipnosis;
    private String[] dataLink;
    private TypedArray dataPhoto;
    private TypedArray dataGenre;
    private ArrayList<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.lv_list);
        adapter = new MovieAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                                MovieData data = new MovieData();
                                                dataProduser = getResources().getStringArray(R.array.data_produser);
                                                dataSutradara = getResources().getStringArray(R.array.data_sutradara);
                                                dataPenulis = getResources().getStringArray(R.array.data_penulis);
                                                dataDistribusi = getResources().getStringArray(R.array.data_distribusi);
                                                dataTayang = getResources().getStringArray(R.array.data_tayang);
                                                dataDurasi = getResources().getStringArray(R.array.data_durasi);
                                                dataTxtgenre = getResources().getStringArray(R.array.data_keterangan);
                                                dataPemeran = getResources().getStringArray(R.array.data_pemeran);
                                                dataKetsipnosis = getResources().getStringArray(R.array.data_sinopsis);
                                                dataLink = getResources().getStringArray(R.array.data_link);
                                                dataPhoto = getResources().obtainTypedArray(R.array.data_picture);
                                                dataGenre = getResources().obtainTypedArray(R.array.data_genre);


                                                data.setProduser(dataProduser[i]);
                                                data.setSutradara(dataSutradara[i]);
                                                data.setPenulis(dataPenulis[i]);
                                                data.setDistribusi(dataDistribusi[i]);
                                                data.setTayang(dataTayang[i]);
                                                data.setDurasi(dataDurasi[i]);
                                                data.setTxtgenre(dataTxtgenre[i]);
                                                data.setPemeran(dataPemeran[i]);
                                                data.setKetSinopsis(dataKetsipnosis[i]);
                                                data.setLink(dataLink[i]);
                                                data.setPicture(dataPhoto.getResourceId(i, -1));
                                                data.setGenre(dataGenre.getResourceId(i,-1));


                                                Intent move = new Intent(MainActivity.this, Detail.class);
                                                move.putExtra(Detail.EXTRA_PERSON, data);
                                                startActivity(move);
                                            }
                                        }
        );
    }

    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataSinopsis = getResources().getStringArray(R.array.data_sinopsis);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(dataPhoto.getResourceId(i, -1));
            movie.setName(dataName[i]);
            movie.setSinopsis(dataSinopsis[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }
}
