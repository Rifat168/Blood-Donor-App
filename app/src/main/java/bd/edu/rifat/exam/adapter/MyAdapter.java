package bd.edu.rifat.exam.adapter;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import bd.edu.rifat.exam.databinding.RowBloodBinding;
import bd.edu.rifat.exam.entities.Blood;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.BloodViewHolder> {


    private List<Blood> bloodList =new ArrayList<>();

    public MyAdapter(Fragment fragment) {

    }

    @NonNull
    @Override
    public BloodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowBloodBinding binding = RowBloodBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new BloodViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BloodViewHolder holder, int position) {
        Blood blood = bloodList.get(position);
        holder.bind(blood);
    }

    @Override
    public int getItemCount() {
        return bloodList.size();
    }


    public void  submitNewList(List<Blood> bloodList){
        this.bloodList = bloodList;
        notifyDataSetChanged();
    }
    class BloodViewHolder extends RecyclerView.ViewHolder {
            private RowBloodBinding binding;


            public void bind(Blood blood){
                binding.setBlood(blood);
            }
            public BloodViewHolder(@NonNull RowBloodBinding binding) {
                super(binding.getRoot());
                this.binding = binding;

                binding.callBtn.setOnClickListener(v -> {
                    final int pos= getAdapterPosition();
                    Toast.makeText(v.getContext(),bloodList.get(pos).getPhone(),Toast.LENGTH_LONG).show();
                    final Intent intent=new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+bloodList.get(pos).getPhone()));
                    Intent chooser=Intent.createChooser(intent,"Which app do you want open");
                    try {
                        v.getContext().startActivity(chooser);
                    }catch (ActivityNotFoundException exception){
                        Toast.makeText(v.getContext(),exception.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }
                });






            }

    }
}
