package nwodo.ikem.com.blueshare;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.app_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(new AppsAdapter(getInstalledApps()));

        /**TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Apps"));
        tabLayout.addTab(tabLayout.newTab().setText("Music"));


        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = findViewById(R.id.viewPager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        // Setting a listener for clicks.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
         */
    }

    public ArrayList<App> getInstalledApps() {
        ArrayList<App> apps = new ArrayList<>();
        List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
        for (int i=0; i<packs.size(); i++){
            PackageInfo p = packs.get(i);

            App app = new App();

            app.setName(p.applicationInfo.loadLabel(getPackageManager()).toString());
            app.setIcon(p.applicationInfo.loadIcon(getPackageManager()));
        }
        return apps;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

}
