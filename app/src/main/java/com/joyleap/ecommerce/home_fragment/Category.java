package com.joyleap.ecommerce.home_fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.joyleap.ecommerce.MainActivity;
import com.joyleap.ecommerce.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.0
 */
public class Category extends Fragment {
    ListView lstCat;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();//fill data


    public Category() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        lstCat = (ListView) view.findViewById(R.id.lstCat);
        setCategory();

        return view;
    }

    private void setCategory(){
        for (int i = 1; i<= 10; i++){
            HashMap<String, String>map  = new HashMap<>();
            map.put("title", "Category - "+ String.valueOf(i));
            arrayList.add(map);
        }
        simpleAdapter = new SimpleAdapter(getActivity(), arrayList, R.layout.adapter_category,
                new String[] {"title"},//variable use
                new int []{R.id.txtTitle});//where place it
        lstCat.setAdapter(simpleAdapter);
        lstCat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String kategori = ((TextView)view.findViewById(R.id.txtTitle)).getText().toString();
                Toast.makeText(getActivity(), kategori,
                        Toast.LENGTH_SHORT).show();

                MainActivity.tabLayout.setupWithViewPager(MainActivity.viewPager);
                MainActivity.viewPager.setCurrentItem(0);
            }
        });
    }

}
