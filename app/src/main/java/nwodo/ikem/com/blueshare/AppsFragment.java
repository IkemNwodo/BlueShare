package nwodo.ikem.com.blueshare;


import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppsFragment extends Fragment {


    public AppsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_apps, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.app_recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(new AppsAdapter(getInstalledApps()));

        return view;
    }

    public ArrayList<App> getInstalledApps() {
        ArrayList<App> apps = new ArrayList<>();
        List<PackageInfo> packs = getContext().getPackageManager().getInstalledPackages(0);
        for (int i=0; i<packs.size(); i++){
            PackageInfo p = packs.get(i);

            App app = new App();

            app.setName(p.applicationInfo.loadLabel(getContext().getPackageManager()).toString());
            app.setIcon(p.applicationInfo.loadIcon(getContext().getPackageManager()));
        }
        return apps;
    }

}
;