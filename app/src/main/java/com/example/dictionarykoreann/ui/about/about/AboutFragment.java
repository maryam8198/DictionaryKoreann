package com.example.dictionarykoreann.ui.about.about;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dictionarykoreann.R;
import com.example.dictionarykoreann.databinding.FragmentAboutBinding;
import com.example.dictionarykoreann.databinding.FragmentHomeBinding;

public class AboutFragment extends Fragment implements View.OnClickListener{

    private AboutViewModel aboutViewModel;
    private FragmentAboutBinding binding;
    TextView txtemail,txtTelegram;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutViewModel =
                new ViewModelProvider(this).get(AboutViewModel.class);

        binding = FragmentAboutBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        txtemail = binding.txtEmail.findViewById(R.id.txtEmail);
        txtTelegram = binding.txtTelegram.findViewById(R.id.txtTelegram);

        txtemail.setOnClickListener(this);
        txtTelegram.setOnClickListener(this);


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
            case R.id.txtEmail:
            {
                SendEmail();
                break;
            }

            case R.id.txtTelegram:
           {
               Intent telegramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/MaryamSoleimani_programer"));
                startActivity(telegramIntent);
               break;
            }
        }

    }


    boolean checkPermission() {
        int state = ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE);
        if(state== PackageManager.PERMISSION_GRANTED)
        {
            return true;
        }
        else
        {
            return  false;
        }
    }



    private void SendEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "soleimanimaryam98@gmail.com", null));
        intent.putExtra("android.intent.extra.SUBJECT", "");
        startActivity(intent);
    }
}