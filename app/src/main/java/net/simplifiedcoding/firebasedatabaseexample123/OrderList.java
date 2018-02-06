package net.simplifiedcoding.firebasedatabaseexample123;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Belal on 2/26/2017.
 */

public class OrderList extends ArrayAdapter<OrderlistAdapter> {
    private Activity context;
    List<OrderlistAdapter> orderList;

    public OrderList(Activity context, List<OrderlistAdapter> orderList) {
        super(context, R.layout.layout_order_list, orderList);
        this.context = context;
        this.orderList = orderList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_order_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewGenre = (TextView) listViewItem.findViewById(R.id.textViewGenre);

        OrderlistAdapter orderlistAdapter = orderList.get(position);
        textViewName.setText(orderlistAdapter.getItem_name());
        textViewGenre.setText(orderlistAdapter.getItem_quantity());

        return listViewItem;
    }
}