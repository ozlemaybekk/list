package com.ozlem.listexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ozlem.listexample.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*viewBİnding'i aktif hale getirelim: */
    private ActivityMainBinding binding1;
    public List<String> prodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*viewBinding'i aktif hale getirelim: */
        binding1 = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding1.getRoot();
        setContentView(view);
    }

    public void submit_onClick(View view) {

        /*Yeni eleman ekleme kontrolü: */
        //Boş mu?
        if (binding1.productID.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Ürün Adını Girmediniz...", Toast.LENGTH_SHORT).show();
        }
        //En az 2 karakter mi?
        else if (binding1.productID.getText().toString().length() < 2) {
            Toast.makeText(this, "Girdiğiniz Ürün Adı en az 2 karakter olmalıdır...", Toast.LENGTH_SHORT).show();
        }
        //Bu eleman listede var mı? Listede yoksa ekle:
        else {
                if (checkList()) {
                    Toast.makeText(this, "Aynı ürünü ekleyemezsiniz...", Toast.LENGTH_SHORT).show();
                }else{
                    prodList.add(binding1.productID.getText().toString());
                }



        }
        ListView listView = (ListView) binding1.listViewID;
        /*listView işlemleri: */
        listView = (ListView) binding1.listViewID;
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, prodList);

        listView.setAdapter(arrayAdapter);

        /*sonraki aşama: */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String value = arrayAdapter.getItem(position);
                //Toast.makeText(getApplicationContext(),value, Toast.LENGTH_SHORT).show();
            }
        });

        /*Butona tıklandığında ad ve */

    }

    private Boolean checkList() {
        return prodList.contains(binding1.productID.getText().toString());

    }
}