package com.example.sala305_pc_04.applicationtoolbar;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import Fragmentos.Fragment1;
import Fragmentos.Fragment2;
import Fragmentos.Fragment3;

public class MainActivity extends AppCompatActivity implements  Fragment1.OnFragmentInteractionListener,Fragment2.OnFragmentInteractionListener,Fragment3.OnFragmentInteractionListener{

    private DrawerLayout drawerLayout;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        //drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);



        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        //Evento de Dar Clic al seleccionar los items el Navigation View

        navView = (NavigationView)findViewById(R.id.navview);

        navView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        boolean fragmentTransaction = false;
                        Fragment fragment = null;

                        switch (menuItem.getItemId()) {
                            case R.id.menu_seccion_1:
                                fragment = new Fragment1();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_seccion_2:
                                fragment = new Fragment2();
                                fragmentTransaction = true;
                                break;
                            case R.id.menu_seccion_3:
                                fragment = new Fragment3();
                                fragmentTransaction = true;
                                break;
                        }
                        if(fragmentTransaction) {
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.content_frame, fragment)
                                    .commit();
                            menuItem.setChecked(true);
                            getSupportActionBar().setTitle(menuItem.getTitle());
                        }
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });




        // FIN Evento de Dar Clic al seleccionar los items el Navigation View
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1 , menu);
        return true;
    }


    //Capturar el evento click de los Botones del ToolBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Nuevo:
                //Log.i("ActionBar", "Nuevo!");
                //Toast para sacar un mensaje emerjente
                Toast.makeText(getApplicationContext(),"Click Sobre Botón Nuevo",Toast.LENGTH_LONG).show();
                return true;
            case R.id.Buscar:
                //Log.i("ActionBar", "Buscar!");
                Toast.makeText(getApplicationContext(),"Click Sobre Botón Busar",Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_setting:
                //Log.i("ActionBar", "Settings!");
                Toast.makeText(getApplicationContext(),"Click Sobre Botón Settings",Toast.LENGTH_LONG).show();
                return true;
            case android.R.id.home:
                drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


//Evento clic del boton flatante
    public void onClickEmail(View view) {
        Snackbar.make(view, "Se presionó el FAB", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
