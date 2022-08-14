package bd.edu.rifat.exam;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

import bd.edu.rifat.exam.data.Datagenerate;
import bd.edu.rifat.exam.databinding.FragmentSecondBinding;
import bd.edu.rifat.exam.entities.Blood;
import bd.edu.rifat.exam.viewmodels.BloodViewModel;


public class SecondFragment extends Fragment {

    private String gender = Blood.MALE;
    private List<String> bloodGrup = Datagenerate.bloodGroup;
    private String bloodGrupName;
    private FragmentSecondBinding binding;
    private BloodViewModel viewModel;
    public static final  String REQUEST_KEY="DATE_TIME_KEY";
    public static final  String DATE_KEY="DATE_KEY";
    public static final  String TIME_KEY="TIME_KEY";

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater);
        viewModel=new ViewModelProvider(requireActivity()).get(BloodViewModel.class);

        initAdapter();

        //SpinnerMethod
        binding.bloodSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                bloodGrupName = adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(getActivity(), courseTitle, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //RadioGroup Method
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                final RadioButton rb = radioGroup.findViewById(i);
                gender = rb.getText().toString();
                /*//Toast.makeText(getActivity(), courseType, Toast.LENGTH_SHORT).show();
                switch (i){
                    case R.id.seip_rb:
                        courseList = Datagenerate.seipStudentList;
                        break;

                    case R.id.paid_rb:
                        courseList = Datagenerate.paidStudentList;
                        break;
                }
                initAdapter();*/
            }
        });





        getChildFragmentManager().setFragmentResultListener(REQUEST_KEY, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {

                if (result.containsKey(DATE_KEY)){
                    final String date=result.getString(DATE_KEY);
                    binding.dateBtn.setText(date);
                }

            }
        });





        binding.dateBtn.setOnClickListener(view -> {
            new DatePickerDialogFragment().show(getChildFragmentManager(),null);

        });


        binding.saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String Name = binding.nameEt.getText().toString();
                final double age = Double.parseDouble(binding.ageEt.getText().toString());
                final String phone = binding.phoneEt.getText().toString();
                final Blood student = new Blood(Name,age,phone,gender,bloodGrupName);
                viewModel.addBloodDonar(student);

                //Toast.makeText(getActivity(), studentName, Toast.LENGTH_SHORT).show();

                Navigation.findNavController(view).navigate(R.id.action_secondFragment_to_thirdFragment);
            }
        });


        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    private void initAdapter() {

        final ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line,bloodGrup);

        binding.bloodSp.setAdapter(adapter);
    }
}