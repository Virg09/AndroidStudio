package bronheeres.politie;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ReadCounter.setContext(this);


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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_vb_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new paginaVB())
                    .commit();
        } else if (id == R.id.nav_col_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new paginacol())
                    .commit();
        } else if (id == R.id.nav_first_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new Inhoudsopgave())
                    .commit();
        } else if (id == R.id.nav_second_layout) {
            ReadCounter.addPagina(this, 0);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new pagina2())
                    .commit();
        } else if (id == R.id.nav_third_layout) {

            ReadCounter.addPagina(this, 1);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new pagina3())
                    .commit();
        } else if (id == R.id.nav_fourth_layout) {

            ReadCounter.addPagina(this, 2);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new pagina4())
                    .commit();
        } else if (id == R.id.nav_fifth_layout) {

            ReadCounter.addPagina(this, 3);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new pagina5())
                    .commit();
        } else if (id == R.id.nav_disc_layout) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new paginadisc())
                    .commit();
        } else if (id == R.id.bargraph) {
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame
                            , new barchar())
                    .commit();

        }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);

        return true;

    }





}
