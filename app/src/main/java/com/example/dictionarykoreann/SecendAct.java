package com.example.dictionarykoreann;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.view.View.OnClickListener;
import com.example.dictionarykoreann.ui.home.HomeFragment;
import java.util.Locale;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.Toast;

public class SecendAct extends AppCompatActivity {

    DatabaseAcsses db;
    private Cursor c;
    SimpleCursorAdapter adapter;

    String[] from = {"word","Pronunciation","means"};
    int[] to = {R.id.rowTxtWord,R.id.rowTxtPronunciation,R.id.rowTxtMeans};

    public String name;
    ListView lst1;
    TextView txtTitel;
    TextToSpeech txtToSpeech;

    private TextToSpeech.OnInitListener OnInitListener;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secend);
        txtTitel = findViewById(R.id.txtTitel);
        lst1 = findViewById(R.id.lst1);
        db = DatabaseAcsses.getInstance(this);

        Intent intent = getIntent();
        name = intent.getStringExtra(HomeFragment.keyflag);

        loadData();

        lst1.setDividerHeight((2));



        txtToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.ERROR) {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }
                if (status == TextToSpeech.SUCCESS) {
                    txtToSpeech.setLanguage(Locale.KOREAN);
                    
                }
            }
        });

        lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.rowTxtWord);
                String words = textView.getText().toString().trim();
                txtToSpeech.speak(words, TextToSpeech.QUEUE_FLUSH, null,null);
            }
        });

    }

    private void loadData() {
        c = db.getdata(name);
        adapter = new SimpleCursorAdapter(this,R.layout.list_row ,c,from,to,1);
        txtTitel.setText(HomeFragment.flag);
        lst1.setAdapter(adapter);


    }
}