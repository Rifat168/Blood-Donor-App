package bd.edu.rifat.exam;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatePickerDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    /*@NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        final Calendar calendar = Calendar.getInstance(Locale.getDefault());
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(),this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        final Calendar calendar = Calendar.getInstance();
        calendar.set(i,i1,i2);
        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        final String setDate = sdf.format(calendar.getTime());

        //Toast.makeText(getActivity(), i+"/"+i1+"/"+i2, Toast.LENGTH_SHORT).show();
        Log.d("TAG", setDate);
    }*/



    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar=Calendar.getInstance();
        final int year=calendar.get(Calendar.YEAR);
        final int month=calendar.get(Calendar.MONTH);
        final int day=calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,year,month,day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        final SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        final  Calendar calendar=Calendar.getInstance();
        calendar.set(year,month,dayOfMonth);

        final String selectedDate=sdf.format(calendar.getTime());
        Toast.makeText(getActivity(), selectedDate, Toast.LENGTH_SHORT).show();

        Bundle bundle=new Bundle();
        bundle.putString(SecondFragment.DATE_KEY,selectedDate);

        getParentFragmentManager().setFragmentResult(SecondFragment.REQUEST_KEY,bundle);
    }
}


