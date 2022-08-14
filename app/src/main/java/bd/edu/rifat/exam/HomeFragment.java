package bd.edu.rifat.exam;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bd.edu.rifat.exam.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {


private FragmentHomeBinding binding;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentHomeBinding.inflate(inflater);

        binding.blooddonarBtn.setOnClickListener(v -> {

            Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_secondFragment);
        });

        binding.bloodRecipentBtn.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_thirdFragment);
        });


        return binding.getRoot();
    }
}