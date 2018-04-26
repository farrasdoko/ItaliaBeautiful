package com.gmail.farasabiyyu12.italiabeautiful;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.gmail.farasabiyyu12.italiabeautiful.Recyclerview.ItemObject;
import com.gmail.farasabiyyu12.italiabeautiful.Recyclerview.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //TODO onCreate Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO set getAllItemList as fill
        List<ItemObject> rowListItem = getAllItemList();

        //TODO RecyclerView Setting
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(rowListItem, getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    //TODO setting getAllItemList
    private List<ItemObject> getAllItemList() {
        List<ItemObject> allItems = new ArrayList<>();

        allItems.add(new ItemObject("Negara Italia", R.drawable.italianflag));
        allItems.add(new ItemObject("Tempat Wisata", R.drawable.colosseum));
        allItems.add(new ItemObject("Orang Ternama", R.drawable.famoust));
        allItems.add(new ItemObject("Tentang", R.drawable.about));

        return allItems;
    }
}
