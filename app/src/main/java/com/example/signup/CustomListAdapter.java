
package com.example.signup;



import static com.example.signup.MainNavigationDrawer.arr_cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    public ArrayList<home_list_pojo> arrayListListener;
    private final List<home_list_pojo> sListenerList;
    Context Scontext;

    String frag;
    public CustomListAdapter(List<home_list_pojo> ListenerList, Context context,String frag){
        Scontext = context;
        this.sListenerList= ListenerList;
        this.arrayListListener = new ArrayList<>();
        this.arrayListListener.addAll(sListenerList);
        this.frag = frag;

    }

    public static class ViewHolder{
        ImageView sItemPic;
        FloatingActionButton cartButton;

    }
    @Override
    public int getCount() {
        return sListenerList.size();
    }

    @Override
    public Object getItem(int position) {
        return sListenerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(Scontext).inflate(R.layout.activity_custom, parent, false);


            holder = new ViewHolder();
            holder.sItemPic = convertView.findViewById(R.id.imageView2);
            holder.cartButton = convertView.findViewById(R.id.cartButton);



            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        try {
            int item = sListenerList.get(position).getItem();
            holder.sItemPic.setImageResource(item);

//
//            for (int i= 0; i< arr_cart.size();i++)
//            {
//                holder.cartButton.setVisibility(View.GONE);
//            }

            if(frag.equals("Cart"))
            {
                holder.cartButton.setVisibility(View.GONE);
            }

            // Set the cart icon based on the clicked state
            boolean isItemClicked = arrayListListener.get(position).isClicked();
            if (isItemClicked) {
                holder.cartButton.setImageResource(R.drawable.ic_cart_clicked);
            } else {
                holder.cartButton.setImageResource(R.drawable.ic_cart_default);

            }

            holder.cartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // Toggle the clicked state of the item


                    boolean isClicked = arrayListListener.get(position).isClicked();
                    arrayListListener.get(position).setClicked(!isClicked);

                    // Update the cart icon based on the new clicked state
                    if (arrayListListener.get(position).isClicked()) {
                        holder.cartButton.setImageResource(R.drawable.ic_cart_clicked);
                        Toast.makeText(Scontext, "Item added to cart", Toast.LENGTH_SHORT).show();
                        arr_cart.add(new home_list_pojo(item));
                    } else {
                        holder.cartButton.setImageResource(R.drawable.ic_cart_default);
                        Toast.makeText(Scontext, "Item removed to cart", Toast.LENGTH_SHORT).show();
                        arr_cart.remove( new home_list_pojo(item));
                    }
                }
            });
        }

        catch (Exception e) {
        }
        return convertView;
    }
}
