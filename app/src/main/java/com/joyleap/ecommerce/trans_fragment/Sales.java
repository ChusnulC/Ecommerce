package com.joyleap.ecommerce.trans_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.joyleap.ecommerce.R;
import com.joyleap.ecommerce.StatusActivity;
import com.joyleap.ecommerce.adapter.SalesAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class Sales extends Fragment {

    ListView lstSales;
    SalesAdapter salesAdapter;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();//fill data


    public Sales() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sales, container, false);
        lstSales = (ListView) view.findViewById(R.id.lstSales);
        setSales();

        return view;
    }

    private void setSales(){

        String[] product = {"product1", "product2"};
        String[] title = {"DVD Belajar Kotlin", "DVD Belajar Android"};
        String[] date = {"Jan, 13 2019 - 20.21pm", "Jan, 10 2019 - 20.21pm" };

        String [] shipment = {"dikirim", "dikirim"};
        String [] drop = {"diterima", "ditolak"};
        String [] finish = {"selesai", "pengembalian"};

        for (int i = 0; i< title.length; i++){
            HashMap<String, String>map  = new HashMap<>();
            map.put("product", product[i]);
            map.put("title", title[i]);
            map.put("date", date[i]);
            map.put("shipment", shipment[i]);
            map.put("drop", drop[i]);
            map.put("finish", finish[i]);
            arrayList.add(map);
        }
        salesAdapter = new SalesAdapter(getActivity(), arrayList, R.layout.adapter_trans,
                new String[] {"product", "title", "date", "shipment", "drop", "finish"},//variable use
                new int []{R.id.imgProduct, R.id.txtTitle, R.id.txtDesc, R.id.imgCar, R.id.imgDrop, R.id.imgFinish});//where place it
        lstSales.setAdapter(salesAdapter);
        lstSales.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String harga = ((TextView)view.findViewById(R.id.txtDesc)).getText().toString();
                Toast.makeText(getActivity(), harga,
                        Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getActivity(), StatusActivity.class));
            }
        });
    }

}
