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

import com.joyleap.ecommerce.MainActivity;
import com.joyleap.ecommerce.R;
import com.joyleap.ecommerce.StatusActivity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class Purchase extends Fragment {

    ListView lstPurchase;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();//fill data


    public Purchase() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_purchase, container, false);
        lstPurchase = (ListView) view.findViewById(R.id.lstPurchase);
        setPurchase();

        return view;
    }

    private void setPurchase(){
        for (int i = 1; i<= 10; i++){
            HashMap<String, String>map  = new HashMap<>();
            map.put("price", "Rp 200.000");
            arrayList.add(map);
        }
        simpleAdapter = new SimpleAdapter(getActivity(), arrayList, R.layout.adapter_trans,
                new String[] {"price"},//variable use
                new int []{R.id.txtDesc});//where place it
        lstPurchase.setAdapter(simpleAdapter);
        lstPurchase.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
