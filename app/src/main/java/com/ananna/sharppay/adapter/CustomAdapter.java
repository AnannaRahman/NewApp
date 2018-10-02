package com.ananna.sharppay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ananna.sharppay.R;
import com.ananna.sharppay.model.ItemMenu;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<ItemMenu> implements View.OnClickListener {


    private ArrayList<ItemMenu> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView tvTitle;
        TextView tvTitlesummery;
        TextView tvDetails;
        TextView tvEndTitle;
        TextView tvRating;
        ImageView iv_image;
        ImageView iv_Rating;
    }


    public CustomAdapter(ArrayList<ItemMenu> data, Context context) {
        super(context, R.layout.template_list_item, data);
        this.dataSet = data;
        this.mContext = context;

    }


    @Override
    public void onClick(View v) {


        int position = (Integer) v.getTag();
        Object object = getItem(position);
        ItemMenu dataModel = (ItemMenu) object;


        switch (v.getId()) {

           /* case R.id.item_info:

                Snackbar.make(v, "Release date " +dataModel.getFeature(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();

                break;
*/

        }


    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ItemMenu dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {


            viewHolder = new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.template_list_item, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvTitlesummery = (TextView) convertView.findViewById(R.id.tvDTitle);
            viewHolder.tvDetails = (TextView) convertView.findViewById(R.id.tvSTitle);
            viewHolder.tvEndTitle = (TextView) convertView.findViewById(R.id.tvEndTitle);
            viewHolder.iv_image = (ImageView) convertView.findViewById(R.id.iv_image);
            viewHolder.iv_Rating = (ImageView) convertView.findViewById(R.id.iv_Rating);
            viewHolder.tvRating = (TextView) convertView.findViewById(R.id.tvRating);
            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.tvTitle.setText(dataModel.getTitle());
       viewHolder.tvTitlesummery.setText(dataModel.getTitleSummery());
        viewHolder.tvDetails.setText(dataModel.getDescription());
        viewHolder.tvEndTitle.setText(dataModel.getEndTitle());
        viewHolder.tvRating.setText(dataModel.getItemRating());
        viewHolder.iv_image.setOnClickListener(this);
        viewHolder.iv_image.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }


    /*Context c;
    ArrayList<ItemMenu> itemMenu;

    public CustomAdapter(Context c, ArrayList<ItemMenu> items) {
        this.c = c;
        this.itemMenu = items;
    }
    private static class ViewHolder {
        TextView txtName;
        TextView txtType;
        TextView txtVersion;
        ImageView info;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the data item for this position
        ItemMenu itemMenu = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {


            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
            viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.version_number);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;


        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtType.setText(dataModel.getType());
        viewHolder.txtVersion.setText(dataModel.getVersion_number());
        viewHolder.info.setOnClickListener(this);
        viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;


       *//* if(view==null)
        {
            CommonUtils.getScreen(c);
            // view= LayoutInflater.from(c).inflate(R.layout.dashboard_menu_item,viewGroup,false);
            view = LayoutInflater.from(c).inflate(R.layout.template_list_item, viewGroup, false);
            view.setLayoutParams(new GridView.LayoutParams((int) (CommonUtils.SCREEN_WIDTH / 3.7), (int) (CommonUtils.SCREEN_HEIGHT / 6.4)));
        }

        final ItemMenu s= (ItemMenu) this.getItem(i);

        ImageView img= (ImageView) view.findViewById(R.id.iv_image);
        TextView tvTitle= (TextView) view.findViewById(R.id.tvTitle);
       TextView tvTitlesummery= (TextView) view.findViewById(R.id.tvTitlesummery);
       TextView tvDetails= (TextView) view.findViewById(R.id.tvDetails);
       TextView tvEndTitle= (TextView) view.findViewById(R.id.tvEndTitle);

        //BIND
        tvTitle.setText(s.getTitle());
        tvDetails.setText(s.getTitle());
        tvEndTitle.setText(s.getEndTitle());
        tvTitlesummery.setText(s.getTitleSummery());
        img.setImageResource(s.getImage());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, s.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;*//*
    }*/
}
