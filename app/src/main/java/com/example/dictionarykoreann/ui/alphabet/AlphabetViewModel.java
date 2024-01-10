package com.example.dictionarykoreann.ui.alphabet;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AlphabetViewModel extends ViewModel {

    private MutableLiveData<String> mText;


    public AlphabetViewModel() {
        mText = new MutableLiveData<>();


    }

    public LiveData<String> getText() {
        return mText;
    }
}