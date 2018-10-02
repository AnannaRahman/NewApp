package com.ananna.sharppay;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ananna.sharppay.adapter.CustomAdapter;
import com.ananna.sharppay.model.ItemMenu;
import com.smarteist.autoimageslider.SliderLayout;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity {

    ArrayList<ItemMenu> itemMenus;
    ListView listView;
    private static CustomAdapter adapter;
    private Context context;
    private CircleImageView profile_image;
    private SliderLayout sliderLayout;
    private ImageView btn_cross;
    private PopupWindow mPopupWindow;
    private RelativeLayout mRelativeLayout;
    private Button closeButton;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        ToolbarInit();
        BottombarInit();
        ModelItems();
        ListHandler();

        sliderLayout = findViewById(R.id.imageSlider);
        /*sliderLayout.getDefaultSize(0,1);*/

        sliderLayout.setIndicatorAnimation(SliderLayout.Animations.SCALE); //set indicator animation by using SliderLayout.Animations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderLayout.setScrollTimeInSec(8); //set scroll delay in seconds :
        setSliderViews();
    }

    public void BottombarInit() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_home:

                                Toast.makeText(MainActivity.this, "Home Clicked ", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.action_recomandation:
                                Toast.makeText(MainActivity.this, "Recommendation Clicked ", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.action_reservation:
                                Toast.makeText(MainActivity.this, "Reservation Clicked ", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.action_payment:
                                Toast.makeText(MainActivity.this, "Payment Clicked ", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.action_profile:
                                Toast.makeText(MainActivity.this, "Profile Clicked ", Toast.LENGTH_SHORT).show();
                                break;

                        }
                        return true;
                    }
                });

    }

    public void Reservation() {

    }

    public void ToolbarInit() {
        TextView toolbartitle = findViewById(R.id.toolbar_title);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbartitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialogClass cdd = new CustomDialogClass(MainActivity.this);
                cdd.show();
               /* Log.v("CLICK", "CLICKED");
                CommonUtils.showAlert(context, "Alert Dialog", "Item is clicked");*/
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void ListHandler() {

        listView = (ListView) findViewById(R.id.list);
        listView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Disallow the touch request for parent scroll on touch of child view
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
            // Setting on Touch Listener for handling the touch inside ScrollView
        });
        //List Adapter
        adapter = new CustomAdapter(itemMenus, getApplicationContext());
        listView.setAdapter(adapter);
        setListViewHeightBasedOnChildren(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ItemMenu dataModel = itemMenus.get(position);


            }
        });

    }

    public void ModelItems() {
        itemMenus = new ArrayList<>();

        itemMenus.add(new ItemMenu(R.drawable.store, "Apple Pie", "Android 1.0", "when set windowTranslucentStatus true, \n" +
                "system will add translucent gray shade above of status  \n" +
                "bar,this is standard style of", "September 23, 2008", "4.5/5"));
        itemMenus.add(new ItemMenu(R.drawable.store, "Banana Bread", "Android 1.1", "when set windowTranslucentStatus \n true, system will add translucent", "February 9, 2009", "3.5/5"));
        itemMenus.add(new ItemMenu(R.drawable.store, "Cupcake", "Android 1.5", "when set windowTranslucentStatus true,\n system will add translucent", "April 27, 2009", "4.3/5"));
        itemMenus.add(new ItemMenu(R.drawable.store, "Donut", "Android 1.6", "when set windowTranslucentStatus true,\n system will add translucent", "September 15, 2009", "4.5/5"));
        itemMenus.add(new ItemMenu(R.drawable.store, "Eclair", "Android 2.0", "when set windowTranslucentStatus true, \nsystem will add translucent", "October 26, 2009", "4.1/5"));
        itemMenus.add(new ItemMenu(R.drawable.store, "Froyo", "Android 2.2", "when set windowTranslucentStatus true,\n system will add translucent", "May 20, 2010", "4.5/5"));
        itemMenus.add(new ItemMenu(R.drawable.store, "Gingerbread", "Android 2.3", "when set windowTranslucentStatus true, \nsystem will add translucent", "December 6, 2010", "4.5/5"));
        itemMenus.add(new ItemMenu(R.drawable.store, "Honeycomb", "Android 3.0", "when set windowTranslucentStatus true,\n system will add translucent", "February 22, 2011", "4.0/5"));
        itemMenus.add(new ItemMenu(R.drawable.store, "Ice Cream Sandwich", "Android 4.0", "when set windowTranslucentStatus true,\n system will add translucent", "October 18, 2011", "4.5/4"));
        itemMenus.add(new ItemMenu(R.drawable.store, "Jelly Bean", "Android 4.2", "when set windowTranslucentStatus true,\n system will add translucent", "July 9, 2012", "4.5/4"));
        itemMenus.add(new ItemMenu(R.drawable.store, "Kitkat", "Android 4.4", "when set windowTranslucentStatus true,\n system will add translucent", "October 31, 2013", "4.5/4"));
        itemMenus.add(new ItemMenu(R.drawable.store, "Lollipop", "Android 5.0", "when set windowTranslucentStatus true,\n system will add translucent", "November 12, 2014", "4.5/4"));
        itemMenus.add(new ItemMenu(R.drawable.store, "Marshmallow", "Android 6.0", "when set windowTranslucentStatus true,\n system will add translucent", "October 5, 2015", "4.5/4"));

    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

//set the default according to value

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setSliderViews() {

        for (int i = 0; i <= 4; i++) {

            SliderView sliderView = new SliderView(this);

            switch (i) {
                case 0:
                    sliderView.setImageDrawable(R.drawable.slider1);
                    break;
                case 1:
                    sliderView.setImageDrawable(R.drawable.slider2);
                    break;
                case 2:
                    sliderView.setImageDrawable(R.drawable.slider3);
                    break;
                case 3:
                    sliderView.setImageDrawable(R.drawable.slider4);
                    break;
                case 4:
                    sliderView.setImageDrawable(R.drawable.slider5);
                    break;
            }

            sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);
            sliderView.setDescription("");
            /*  sliderView.setDescription("setDescription " + (i + 1));*/
            final int finalI = i;
            sliderView.setOnSliderClickListener(new SliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(SliderView sliderView) {
                    Toast.makeText(MainActivity.this, "This is slider " + (finalI + 1), Toast.LENGTH_SHORT).show();
                }
            });

            //at last add this view in your layout :
            sliderLayout.addSliderView(sliderView);
        }
    }
}
