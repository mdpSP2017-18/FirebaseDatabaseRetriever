package net.simplifiedcoding.firebasedatabaseexample123;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Belal on 2/26/2017.
 */
@IgnoreExtraProperties
public class OrderlistAdapter {
    private String item_name;
    private String item_quantity;



    public OrderlistAdapter(){
        //this constructor is required
    }

    public OrderlistAdapter(String item_name, String item_quantity) {

        this.item_name = item_name;
        this.item_quantity = item_quantity;

    }



    public String getItem_name() {
        return item_name;
    }

    public String getItem_quantity() {
        return item_quantity;
    }


}
