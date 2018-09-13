package com.example.anjali.simpletodopart2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ArrayList<String> items;
    private ArrayList<String> items2;
    private ArrayList<String> items3;
    private ArrayList<String> items4;
    private ArrayList<String> items5;
    private ArrayList<String> items6;

    public int tab = 1;


    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;


    private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        File todoFile2 = new File(filesDir, "todo2.txt");
        File todoFile3 = new File(filesDir, "todo3.txt");
        File todoFile4 = new File(filesDir, "todo4.txt");
        File todoFile5 = new File(filesDir, "todo5.txt");
        File todoFile6 = new File(filesDir, "todo6.txt");


        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
            items2 = new ArrayList<String>(FileUtils.readLines(todoFile2));
            items3 = new ArrayList<String>(FileUtils.readLines(todoFile3));
            items4 = new ArrayList<String>(FileUtils.readLines(todoFile4));
            items5 = new ArrayList<String>(FileUtils.readLines(todoFile5));
            items6 = new ArrayList<String>(FileUtils.readLines(todoFile6));

        } catch (IOException e) {
            items = new ArrayList<String>();
            items2 = new ArrayList<String>();
            items3 = new ArrayList<String>();
            items4 = new ArrayList<String>();
            items5 = new ArrayList<String>();
            items6 = new ArrayList<String>();

        }
    }

    private void writeItems(int tab) {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        File todoFile2 = new File(filesDir, "todo2.txt");
        File todoFile3 = new File(filesDir, "todo3.txt");
        File todoFile4 = new File(filesDir, "todo4.txt");
        File todoFile5 = new File(filesDir, "todo5.txt");
        File todoFile6 = new File(filesDir, "todo6.txt");
        try {
            if (tab==1){
                FileUtils.writeLines(todoFile, items);
            }
            else if (tab==2){
                FileUtils.writeLines(todoFile2, items2);

            }else if (tab==3){
                FileUtils.writeLines(todoFile3, items3);

            }else if (tab==4){
                FileUtils.writeLines(todoFile4, items4);

            }else if (tab==5){
                FileUtils.writeLines(todoFile5, items5);

            }else if (tab==6){
                FileUtils.writeLines(todoFile6, items6);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // ADD HERE
        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        items2 = new ArrayList<String>();
        items3 = new ArrayList<String>();
        items4 = new ArrayList<String>();
        items5 = new ArrayList<String>();
        items6 = new ArrayList<String>();


        readItems(); // <---- Add this line
//took this?
        if (tab==1){
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items);
            lvItems.setAdapter(itemsAdapter);

            setupListViewListener();
        }
        else if (tab==2){
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items2);
            lvItems.setAdapter(itemsAdapter);

            setupListViewListener();
        }
        else if (tab==3){
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items3);
            lvItems.setAdapter(itemsAdapter);

            setupListViewListener();
        }else if (tab==4){
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items4);
            lvItems.setAdapter(itemsAdapter);

            setupListViewListener();
        }else if (tab==5){
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items5);
            lvItems.setAdapter(itemsAdapter);

            setupListViewListener();
        }else if (tab==6){
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items6);
            lvItems.setAdapter(itemsAdapter);

            setupListViewListener();
        }


    }
//fix?
    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position

                        if (tab==1){
                            items.remove(pos);
                            // Refresh the adapter
                            itemsAdapter.notifyDataSetChanged();
                            writeItems(tab);
                            // Return true consumes the long click event (marks it handled)
                            return true;
                        }else if (tab==2){
                            items2.remove(pos);
                            // Refresh the adapter
                            itemsAdapter.notifyDataSetChanged();
                            writeItems(tab);
                            // Return true consumes the long click event (marks it handled)
                            return true;
                        }else if (tab==3){
                            items3.remove(pos);
                            // Refresh the adapter
                            itemsAdapter.notifyDataSetChanged();
                            writeItems(tab);
                            // Return true consumes the long click event (marks it handled)
                            return true;
                        }else if (tab==4){
                            items4.remove(pos);
                            // Refresh the adapter
                            itemsAdapter.notifyDataSetChanged();
                            writeItems(tab);
                            // Return true consumes the long click event (marks it handled)
                            return true;
                        }else if (tab==5){
                            items5.remove(pos);
                            // Refresh the adapter
                            itemsAdapter.notifyDataSetChanged();
                            writeItems(tab);
                            // Return true consumes the long click event (marks it handled)
                            return true;
                        }else {
                            items6.remove(pos);
                            // Refresh the adapter
                            itemsAdapter.notifyDataSetChanged();
                            writeItems(tab);
                            // Return true consumes the long click event (marks it handled)
                            return true;
                        }

                    }

                });
    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
        writeItems(tab);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            tab=1;
            // Handle the camera action
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items);
            lvItems.setAdapter(itemsAdapter);
        } else if (id == R.id.nav_gallery) {
            tab=2;
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items2);
            lvItems.setAdapter(itemsAdapter);

        } else if (id == R.id.nav_slideshow) {
            tab=3;
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items3);
            lvItems.setAdapter(itemsAdapter);
        } else if (id == R.id.nav_manage) {
            tab=4;
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items4);
            lvItems.setAdapter(itemsAdapter);

        } else if (id == R.id.nav_share) {

            tab=5;
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items5);
            lvItems.setAdapter(itemsAdapter);

        } else if (id == R.id.nav_send) {
            tab=6;
            itemsAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, items6);
            lvItems.setAdapter(itemsAdapter);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
