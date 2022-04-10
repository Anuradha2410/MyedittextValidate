package com.example.myedittextvalidate;

import android.os.Bundle;
import java.util.ArrayList;
import android.widget.Toast;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myedittextvalidate.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<EditText> edtList = new ArrayList<>();
        edtList.add(binding.editTextTextPersonName);
        edtList.add(binding.editTextTextPersonName2);
        edtList.add(binding.editTextTextPersonName3);
        edtList.add(binding.editTextTextPersonName4);
        edtList.add(binding.editTextTextPersonName5);

        binding.button.setOnClickListener(v->{
            if(this.validateEDT(edtList)){
                Toast.makeText(this, "All Textbox contain data", Toast.LENGTH_SHORT).show();
            }

            String x = binding.editTextTextPassword.getText().toString();
            Toast.makeText(this, x, Toast.LENGTH_SHORT).show();

        });
    }

    private boolean validateEDT(ArrayList<EditText> edtlist){
        for(EditText et : edtlist){
            if(! hasText(et)){
                return false;
            }
        }
        return true;
    }

    public boolean hasText(EditText editext){
        String text = editext.getText().toString().trim();

        if(text.length() == 0){
            if(binding.editTextTextPersonName5.getId() == editext.getId()){
                editext.setError("custom message");
//                Toast.makeText(this, getResources().getResourceEntryName(editext.getId()), Toast.LENGTH_SHORT).show();
                return false;
            }

            if(getResources().getResourceEntryName(editext.getId()).equals("editTextTextPersonName4")){
//                Toast.makeText(this, "editText 4", Toast.LENGTH_SHORT).show();
//                Toast.makeText(this, getResources().getResourceEntryName(editext.getId()), Toast.LENGTH_SHORT).show();
            }
            editext.setError("Required");
        }
        return true;
    }
}