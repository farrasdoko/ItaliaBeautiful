package com.gmail.farasabiyyu12.italiabeautiful;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gmail.farasabiyyu12.italiabeautiful.Recyclerview.CardViewAdapter;
import com.gmail.farasabiyyu12.italiabeautiful.Recyclerview.ItemObject;

import java.util.ArrayList;
import java.util.List;

public class WisataActivity extends AppCompatActivity {

    TextView judulwisata, deskripsiwisata;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        //TODO declare rowList as List
        List<ItemObject> rowListTempat = getAllItemList();
        List<ItemObject> rowListOrang = getAllItem();

        //TODO Toolbar Method
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initCollapsingToolbar();

        //TODO GetIntent
        Intent inamaw = getIntent();

        String snamaw = inamaw.getStringExtra("namaw");

        //TODO Textview Method
        judulwisata = findViewById(R.id.judulwisata);
        deskripsiwisata = findViewById(R.id.deskripsiwisata);

        //TODO "Tempat Wisata" / "Orang Ternama" Method
        if (snamaw.equals("Tempat Wisata")) {
            judulwisata.setText(R.string.judul);
            deskripsiwisata.setText(R.string.deskripsi_wisata);

            //TODO Recyclerview "Tempat Wisata"
            recyclerView = findViewById(R.id.recycler_view_wisata);
            recyclerView.setAdapter(new CardViewAdapter(rowListTempat, getApplicationContext()));

            recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(), true));

            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
            recyclerView.setHasFixedSize(true);
        }else if (snamaw.equals("Orang Ternama")){
            judulwisata.setText(R.string.judul);
            deskripsiwisata.setText(R.string.deskripsi_orang);

            //TODO Recyclerview "Orang Ternama"
            recyclerView = findViewById(R.id.recycler_view_wisata);
            recyclerView.setAdapter(new CardViewAdapter(rowListOrang, getApplicationContext()));

            recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(), true));

            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
            recyclerView.setHasFixedSize(true);
        }

        //TODO Glide Image Into AppBar
        try {
            Glide.with(this).load(R.drawable.backgroundappbar).into((ImageView) findViewById(R.id.appback2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO getAllItem
    private List<ItemObject> getAllItem() {
        List<ItemObject> getAllItOrang = new ArrayList<>();

        getAllItOrang.add(new ItemObject("Michaelangelo", R.drawable.michaelangelo));
        getAllItOrang.add(new ItemObject("Sandro Botticelli", R.drawable.sandrobotti));
        getAllItOrang.add(new ItemObject("Douglas Darien Walker", R.drawable.dougwalker));
        getAllItOrang.add(new ItemObject("Emma Morano", R.drawable.emmamorano));
        getAllItOrang.add(new ItemObject("Guccio Gucci", R.drawable.gucciogucci));
        getAllItOrang.add(new ItemObject("John Cabot", R.drawable.johncabot));
        return getAllItOrang;
    }

    //TODO getAllItemList
    private List<ItemObject> getAllItemList() {
        List<ItemObject> getAllIt = new ArrayList<>();

        getAllIt.add(new ItemObject("Colosseum", R.drawable.colosseum));
        getAllIt.add(new ItemObject("St Mark's Basilica", R.drawable.basilikasantomarkus));
        getAllIt.add(new ItemObject("Doge's Palace", R.drawable.dogespalace));
        getAllIt.add(new ItemObject("Church of San Giorgio Maggiore", R.drawable.curchofsangiorgio));

        return getAllIt;
    }

    //TODO Set Collapsing Toolbar
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    collapsingToolbar.setCollapsedTitleTextColor(Color.WHITE);
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
    private int dpToPx() {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, r.getDisplayMetrics()));
    }
}
