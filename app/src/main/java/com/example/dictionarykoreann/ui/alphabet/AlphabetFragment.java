package com.example.dictionarykoreann.ui.alphabet;

import android.content.ClipData;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dictionarykoreann.R;
import com.example.dictionarykoreann.databinding.FragmentAlphabetBinding;

import java.util.Locale;

public class AlphabetFragment extends Fragment  implements View.OnClickListener{

    private AlphabetViewModel alphabetViewModel;
    private FragmentAlphabetBinding binding;





    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        alphabetViewModel =
                new ViewModelProvider(this).get(AlphabetViewModel.class);

        binding = FragmentAlphabetBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        return root;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



    @Override
    public void onClick(View view) {






    }



}