package net.simplifiedcoding.firebasedatabaseexample123;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonClearList;
    ListView listViewOrders;

    //a list to store all the artist from firebase database
    List<OrderlistAdapter> orderlistAdapters;

    //our database reference object
    DatabaseReference databaseOrderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the reference of orderList node
        databaseOrderList = FirebaseDatabase.getInstance().getReference("Order_List");

        //getting views
        listViewOrders = (ListView) findViewById(R.id.listViewOrders);

        //list to store orderList
        orderlistAdapters = new ArrayList<>();

        buttonClearList = (Button) findViewById (R.id.buttonClearList);


       buttonClearList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseOrderList.removeValue();

            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseOrderList.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                orderlistAdapters.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting orderlistAdapter
                    OrderlistAdapter orderlistAdapter = postSnapshot.getValue(OrderlistAdapter.class);
                    //adding orderlistAdapter to the list
                    orderlistAdapters.add(orderlistAdapter);
                }

                //creating adapter
                OrderList orderlistAdapter = new OrderList(MainActivity.this, orderlistAdapters);
                //attaching adapter to the listview
                listViewOrders.setAdapter(orderlistAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}
