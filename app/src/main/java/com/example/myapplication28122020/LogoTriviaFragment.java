package com.example.myapplication28122020;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.myapplication28122020.databinding.FragmentLogoTriviaBinding;

public class LogoTriviaFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private FragmentLogoTriviaBinding binding;
    private String name;
    private int choice;
    private Bundle bundle = new Bundle();

    public LogoTriviaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLogoTriviaBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String saludo = getString(R.string.saludo, name);
        binding.tvName.setText(saludo);
        binding.rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radiobutton = binding.rdGroup.findViewById(checkedId);
                int index = binding.rdGroup.indexOfChild(radiobutton);
                switch (index){
                    case 0:
                        choice = 0;
                        break;
                    case 1:
                        choice = 1;
                        break;
                    case 2:
                        choice = 2;
                        break;
                    case 3:
                        choice = 3;
                        break;
                    default:
                        choice = 4;
                        break;
                }
            }
        });

        binding.btnEnviarResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("param1", name);
                if ( choice == 1){
                    Navigation.findNavController(v)
                            .navigate(R.id.action_logoTriviaFragment_to_winnerFragment, bundle);
                } else {
                    Navigation.findNavController(v)
                            .navigate(R.id.action_logoTriviaFragment_to_loserFragment, bundle);
                }
            }
        });
    }

}