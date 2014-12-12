package dheera.cs160.berkeley.edu.salecellnew;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class merchant extends Activity {

    MyCustomAdapter dataAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant);

        //Generate list View from ArrayList
        displayListView();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.merchant, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void displayListView() {

        //Array list of countries
        ArrayList<ItemData> itemList = new ArrayList<ItemData>();
        ItemData itemdata = new ItemData("Men's Boots",false);
        itemList.add(itemdata);
        itemdata = new ItemData("Women's Dresses",true);
        itemList.add(itemdata);
        itemdata = new ItemData("Medium Cardigans",false);
        itemList.add(itemdata);
        itemdata = new ItemData("Women's Trousers",true);
        itemList.add(itemdata);


        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.itemdata, itemList);
        ListView listView = (ListView) findViewById(R.id.itemlist);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                ItemData itemdata = (ItemData) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Clicked on Row: " + itemdata.getItemName(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }


    //MY CUSTOM ADAPTER

    private class MyCustomAdapter extends ArrayAdapter<ItemData> {

        private ArrayList<ItemData> countryList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<ItemData> countryList) {
            super(context, textViewResourceId, countryList);
            this.countryList = new ArrayList<ItemData>();
            this.countryList.addAll(countryList);
        }

        private class ViewHolder {
            TextView itemname;
            CheckBox itemselected;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.itemdata, null);

                holder = new ViewHolder();
                holder.itemname = (TextView) convertView.findViewById(R.id.itemName);
                holder.itemselected = (CheckBox) convertView.findViewById(R.id.itemSelected);
                convertView.setTag(holder);

//                holder.itemname.setOnClickListener( new View.OnClickListener() {
//                    public void onClick(View v) {
//                        CheckBox cb = (CheckBox) v ;
//                        ItemData itemdata = (ItemData) cb.getTag();
//                        Toast.makeText(getApplicationContext(),
//                                "Clicked on Checkbox: " + cb.getText() +
//                                        " is " + cb.isChecked(),
//                                Toast.LENGTH_LONG).show();
//                        itemdata.setItemSelected(cb.isChecked());
//                    }
//                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            ItemData itemdata = countryList.get(position);
            holder.itemname.setText(itemdata.getItemName());

            holder.itemselected.setChecked(itemdata.getItemSelected());

            return convertView;

        }

    }

}
