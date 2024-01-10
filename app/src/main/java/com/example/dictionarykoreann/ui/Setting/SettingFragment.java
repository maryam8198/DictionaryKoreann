package com.example.dictionarykoreann.ui.Setting;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dictionarykoreann.R;
import com.example.dictionarykoreann.databinding.FragmentSettingBinding;

public class SettingFragment extends Fragment  implements View.OnClickListener{

    private SettingViewModel settingViewModel;
    private FragmentSettingBinding binding;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    RadioGroup rgmeans,rgpronunciation,rgword;
    TextView txtsizes;
    SeekBar skSize;
   public int numberSkSize;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        settingViewModel =
                new ViewModelProvider(this).get(SettingViewModel.class);

        binding = FragmentSettingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.rgmeans.findViewById(R.id.rgmeans);
        binding.rgpronunciation.findViewById(R.id.rgpronunciation);
        binding.rgword.findViewById(R.id.rgword);
        skSize=  binding.sksize.findViewById(R.id.sksize);
        txtsizes =binding.txtsizes.findViewById(R.id.txtsizes);
        rgmeans = binding.rgmeans.findViewById(R.id.rgmeans);
        rgpronunciation = binding.rgpronunciation.findViewById(R.id.rgpronunciation);
        rgword = binding.rgword.findViewById(R.id.rgword);
        binding.txtWords.findViewById(R.id.txtWords);
        binding.txtPronunciations.findViewById(R.id.txtPronunciations);
        binding.txtMeanss.findViewById(R.id.txtMeanss);


        rgword.setVisibility(View.GONE);
        rgpronunciation.setVisibility(View.GONE);
        rgmeans.setVisibility(View.GONE);




        binding.btnsave.setOnClickListener(this);
        binding.txtWords.setOnClickListener(this);
        binding.txtPronunciations.setOnClickListener(this);
        binding.txtMeanss.setOnClickListener(this);


        sharedPreferences= getContext().getSharedPreferences("sharepreferences",MODE_PRIVATE);

        editor=sharedPreferences.edit();


        skSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtsizes.setTextSize(skSize.getProgress());
                numberSkSize=skSize.getProgress();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        loadPreferenceData();
        return root;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnsave:
            {
                //loadPreferenceData();
                editor.putFloat("txtsize",skSize.getProgress()).commit();



                int check = rgmeans.getCheckedRadioButtonId();
                RadioButton RbColorMeans = rgmeans.findViewById(check);
                if (check !=-1){
                    editor.putString("txtcolor",RbColorMeans.getText().toString().trim()).commit();

                }

                break;
            }

            case R.id.txtWords:
            {
                rgword.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.txtPronunciations:
            {
                rgpronunciation.setVisibility(View.VISIBLE);
                break;
            }
            case R.id.txtMeanss:
            {
                rgmeans.setVisibility(View.VISIBLE);
                break;
            }
        }

    }

    void loadPreferenceData() {
        if(sharedPreferences.contains("txtsize"))
        {
            txtsizes.setTextSize(sharedPreferences.getFloat("txtsize", 20));
        }

        if (sharedPreferences.contains("txtcolor"))
        {
            String txtColor = sharedPreferences.getString("txtcolor", "مشکی");
            if (txtColor.equals("آبی"))
            {
                RadioButton RbBluem =  binding.RbBluem.findViewById(R.id.RbBluem);
                RbBluem.setChecked(true);
                txtsizes.setTextColor(getResources().getColor(
                        android.R.color.holo_blue_dark
                ));



            }

             else if(txtColor.equals("قرمز"))
             {
                RadioButton RbRedm = binding.RbRedm.findViewById(R.id.RbRedm);
                RbRedm.setChecked(true);
                txtsizes.setTextColor(getResources().getColor(
                        android.R.color.holo_red_dark
                ));
                
            }
            else
            {
                RadioButton RbBlackm =  binding.RbBlackm.findViewById(R.id.RbBlackm);
                RbBlackm.setChecked(true);
                txtsizes.setTextColor(getResources().getColor(
                        android.R.color.black
                ));
            }


        }

        


    }


}