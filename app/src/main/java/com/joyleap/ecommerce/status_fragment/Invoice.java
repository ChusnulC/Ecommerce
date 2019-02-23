package com.joyleap.ecommerce.status_fragment;


import android.graphics.Paint;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.joyleap.ecommerce.MainActivity;
import com.joyleap.ecommerce.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class Invoice extends Fragment {

    LinearLayout linearHistori;
    TextView txtHistori;
    ListView lstHistori;
    SimpleAdapter simpleAdapter;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();//fill data


    public Invoice() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_invoice, container, false);

        linearHistori = (LinearLayout) view.findViewById(R.id.linearHistori);
        txtHistori = (TextView) view.findViewById(R.id.txtHistori);
        lstHistori = (ListView) view.findViewById(R.id.lstHistori);

        txtHistori.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);//underline
        txtHistori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(linearHistori.getVisibility() == View.GONE){
                    linearHistori.setVisibility(View.VISIBLE);
                    txtHistori.setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.arrow_up_float, 0);
                }else {
                    linearHistori.setVisibility(View.GONE);
                    txtHistori.setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.arrow_down_float, 0);
                }
            }
        });

        setHistori();

        return view;
    }

    private void setHistori(){
        for (int i = 1; i<= 10; i++){
            HashMap<String, String>map  = new HashMap<>();
            map.put("date", "Agustus,  " + String.valueOf(i) + " 2020");
            arrayList.add(map);
        }
        simpleAdapter = new SimpleAdapter(getActivity(), arrayList, R.layout.adapter_histori,
                new String[] {"date"},//variable use
                new int []{R.id.txtDate});//where place it
        lstHistori.setAdapter(simpleAdapter);
        lstHistori.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
