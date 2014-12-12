package dheera.cs160.berkeley.edu.salecellnew;
import android.media.Image;
import android.widget.ImageView;

import java.util.HashMap;
/**
 * Created by Dheean on 12/11/14.
 */

public class ItemData {

    String itemName = null;
    boolean itemSelected = false;


    public ItemData(String itemName, boolean itemSelected) {
        this.itemName = itemName;
        this.itemSelected = itemSelected;

    }

    public String getItemName() { return itemName; }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean getItemSelected() {
        return itemSelected;
    }

    public void setItemSelected(boolean itemSelected) {
        this.itemSelected = itemSelected;
    }




}

