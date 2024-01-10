package com.example.dictionarykoreann.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.dictionarykoreann.R;
import com.example.dictionarykoreann.SecendAct;
import com.example.dictionarykoreann.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public static String flag = "";
    public static String keyflag = "type";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.imgColor.findViewById(R.id.imgColor);
        binding.imgAnimal.findViewById(R.id.imgAnimal);
        binding.imgEmotions.findViewById(R.id.imgEmotions);
        binding.imgNmber.findViewById(R.id.imgNmber);
        binding.imgFrute.findViewById(R.id.imgFrute);
        binding.imgFamily.findViewById(R.id.imgFamily);
        binding.imgWeather.findViewById(R.id.imgWeather);
        binding.imgWeek.findViewById(R.id.imgWeek);
        binding.imgSport.findViewById(R.id.imgSport);
        binding.imgBody.findViewById(R.id.imgBody);
        binding.imgConversation.findViewById(R.id.imgConversation);
        binding.imgDoctor.findViewById(R.id.imgDoctor);
        binding.imgJob.findViewById(R.id.imgJob);
        binding.imgComputer.findViewById(R.id.imgComputer);
        binding.imgTransport.findViewById(R.id.imgTransport);
        binding.imgTshert.findViewById(R.id.imgTshert);
        binding.imgBuy.findViewById(R.id.imgBuy);
        binding.imgDirection.findViewById(R.id.imgDirection);
        binding.imgMuisc.findViewById(R.id.imgMuisc);
        binding.imgHome.findViewById(R.id.imgHome);
        binding.imgRestaurant.findViewById(R.id.imgRestaurant);
        binding.imgFood.findViewById(R.id.imgFood);
        binding.imgPronouns.findViewById(R.id.imgPronouns);
        binding.imgMilitary.findViewById(R.id.imgMilitary);
        binding.imgNature.findViewById(R.id.imgNature);
        binding.imgCity.findViewById(R.id.imgCity);


        binding.imgColor.setOnClickListener(this);
        binding.imgAnimal.setOnClickListener(this);
        binding.imgEmotions.setOnClickListener(this);
        binding.imgNmber.setOnClickListener(this);
        binding.imgFrute.setOnClickListener(this);
        binding.imgFamily.setOnClickListener(this);
        binding.imgSport.setOnClickListener(this);
        binding.imgWeek.setOnClickListener(this);
        binding.imgWeather.setOnClickListener(this);
        binding.imgBody.setOnClickListener(this);
        binding.imgConversation.setOnClickListener(this);
        binding.imgDoctor.setOnClickListener(this);
        binding.imgJob.setOnClickListener(this);
        binding.imgComputer.setOnClickListener(this);
        binding.imgTransport.setOnClickListener(this);
        binding.imgTshert.setOnClickListener(this);
        binding.imgBuy.setOnClickListener(this);
        binding.imgDirection.setOnClickListener(this);
        binding.imgMuisc.setOnClickListener(this);
        binding.imgHome.setOnClickListener(this);
        binding.imgRestaurant.setOnClickListener(this);
        binding.imgFood.setOnClickListener(this);
        binding.imgPronouns.setOnClickListener(this);
        binding.imgMilitary.setOnClickListener(this);
        binding.imgAdjective.setOnClickListener(this);
        binding.imgNature.setOnClickListener(this);
        binding.imgCity.setOnClickListener(this);
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
            case R.id.imgColor:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="رنگ";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);

                break;
            }

            case R.id.imgAnimal:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="حیوانات";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);

                break;
            }

            case R.id.imgEmotions:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="احساسات";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);

                break;
            }

            case R.id.imgNmber:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="اعداد";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);

                break;
            }
            case R.id.imgFrute:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="میوه";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);

                break;
            }

            case R.id.imgFamily:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="خانواده";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);

                break;
            }

            case R.id.imgSport:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="ورزش";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgWeather:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="آب و هوا";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgWeek:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="تقویم";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgBody:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="اعضا بدن";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgConversation:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="مکالمه" ;
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgDoctor:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="ارژانس";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgJob:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="مشاغل";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgComputer:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="کامپیوتر";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgTransport:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="حمل ونقل";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgTshert:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="لباس";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgBuy:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="خرید";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgDirection:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="مسیرها";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgMuisc:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="موسیقی";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgHome:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="خانه";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgRestaurant:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="رستوران";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgFood:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="غذا";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgPronouns:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="ضمایر";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgAdjective:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="صفت";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgMilitary:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="نظامی";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }

            case R.id.imgNature:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="طبیعت";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }


            case R.id.imgCity:
            {

                Intent intent=new Intent(getActivity(),SecendAct.class);
                flag="درشهر";
                intent.putExtra(keyflag,flag.toString().trim());
                startActivity(intent);
                break;
            }





        }

    }
}