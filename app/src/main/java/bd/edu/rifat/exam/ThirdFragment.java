package bd.edu.rifat.exam;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import bd.edu.rifat.exam.adapter.MyAdapter;
import bd.edu.rifat.exam.databinding.FragmentThirdBinding;
import bd.edu.rifat.exam.entities.Blood;
import bd.edu.rifat.exam.viewmodels.BloodViewModel;


public class ThirdFragment extends Fragment {

       private FragmentThirdBinding binding;
       private MyAdapter adapter;
       private BloodViewModel viewModel;
    public ThirdFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentThirdBinding.inflate(inflater);
        viewModel=new ViewModelProvider(requireActivity()).get(BloodViewModel.class);
        adapter = new MyAdapter(this);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(RecyclerView.VERTICAL);
        binding.donarRv.setAdapter(adapter);
        binding.donarRv.setLayoutManager(llm);
        viewModel.getAllBloodDonar().observe(getViewLifecycleOwner(), new Observer<List<Blood>>() {
            @Override
            public void onChanged(List<Blood> bloodList) {
                adapter.submitNewList(bloodList);
                Toast.makeText(getContext(), "Total Donar :"+bloodList.size(), Toast.LENGTH_SHORT).show();
            }
        });




        return binding.getRoot();
    }
}