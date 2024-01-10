package com.example.dictionarykoreann.ui.search;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dictionarykoreann.DatabaseAcsses;
import com.example.dictionarykoreann.R;
import com.example.dictionarykoreann.databinding.FragmentSearchBinding;

import java.util.Locale;

public class SearchFragment extends Fragment {

    private SearchViewModel searchViewModel;
    private FragmentSearchBinding binding;

    DatabaseAcsses db;
    Cursor c;
    SimpleCursorAdapter adapter;

    String[] from = {"word","Pronunciation","means"};
    int[] to = {R.id.rowTxtWord,R.id.rowTxtPronunciation,R.id.rowTxtMeans};

    ListView lstword;
    EditText edSearch;
    ImageView img;
    TextView txtsearch;
    TextToSpeech txtToSpeech;

    @SuppressLint("ResourceAsColor")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        searchViewModel =
                new ViewModelProvider(this).get(SearchViewModel.class);

        binding = FragmentSearchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        lstword=binding.lstword.findViewById(R.id.lstword);
        edSearch= binding.edSearch.findViewById(R.id.edSearch);
        img=binding.img.findViewById(R.id.img);
        txtsearch=binding.txtsearch.findViewById(R.id.txtsearch);

        lstword.setVisibility(View.GONE);

       lstword.setDividerHeight((2));

        edSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                lstword.setVisibility(View.VISIBLE);

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                img.setVisibility(View.GONE);
                txtsearch.setVisibility(View.GONE);

            }

            @Override
            public void afterTextChanged(Editable editable) {
                search(editable.toString().trim());
                lstword.setVisibility(View.VISIBLE);

            }
        });



        lstword.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView textView =  view.findViewById(R.id.rowTxtWord);
                String toSpeak = textView.getText().toString().trim();
                txtToSpeech.setSpeechRate(Float.parseFloat("0.75"));
                txtToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);


            }
        });
        txtToSpeech =new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    txtToSpeech.setLanguage(Locale.KOREAN); } }
        });



        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void search(String txt) {

        db = new DatabaseAcsses(getContext());
        c = db.searchword(txt);
        adapter = new SimpleCursorAdapter(getContext(),R.layout.list_row ,c,from,to,1);
        lstword.setAdapter(adapter);


    }

    public void onPause(){
        if(txtToSpeech != null){
            txtToSpeech.stop();
            txtToSpeech.shutdown();
        }
        super.onPause();
    }




}