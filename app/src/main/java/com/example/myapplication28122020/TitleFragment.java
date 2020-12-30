package com.example.myapplication28122020;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavAction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication28122020.databinding.FragmentTitleBinding;

public class TitleFragment extends Fragment {
    private FragmentTitleBinding binding;
    private String name;
    private Bundle bundle;

    public TitleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTitleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //binding.etName.setSelection(0);
        bundle = new Bundle();


        binding.btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = binding.etName.getText().toString();
                bundle.putString("param1", name);
                if(name.length()==0){
                    Toast.makeText(getContext(), "Campo vacío, ingrese un nombre"
                            , Toast.LENGTH_LONG).show();
                } else {
                    Navigation.findNavController(v)
                            .navigate(R.id.action_titleFragment_to_logoTriviaFragment, bundle);
                }
            }
        });
    }
}