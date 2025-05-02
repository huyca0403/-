package com.eyesartist.magneton.ui;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.eyesartist.magneton.R;

public class MainScreen extends Fragment {
    private long pressedTime;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mainview,container,false);
        
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                //không có gì
                Log.d("tag","k cho ra");
                if(pressedTime+2000> System.currentTimeMillis()){
                    requireActivity().finishAffinity();
                }else {
                    Toast.makeText(getContext(),"Không cho ra",Toast.LENGTH_LONG).show();
                    Log.d("lol", String.valueOf(pressedTime));
                    pressedTime = System.currentTimeMillis();
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this,callback);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        NavController navController = Navigation.findNavController(view);
        view.findViewById(R.id.taskbar_left_icon).setOnClickListener(v->{
            navController.navigate(R.id.action_mainScreen_to_secondaryScreen);
        });
    }
}
