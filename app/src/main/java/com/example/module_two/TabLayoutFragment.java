package com.example.module_two;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;


public class TabLayoutFragment extends Fragment {
    static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    ImageView imageView;

    public TabLayoutFragment() {
        // Required empty public constructor
    }

    public static TabLayoutFragment newInstance(int i) {
        Bundle bundle = new Bundle();
        TabLayoutFragment fragment = new TabLayoutFragment();
        bundle.putInt("item", i);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = (ImageView) view.findViewById(R.id.my_image_view_2);
        Bundle bundle = getArguments();
        arrayList.add(R.drawable.pic_noodle);
        arrayList.add(R.drawable.pic_banana);
        arrayList.add(R.drawable.pic_snack);
        arrayList.add(R.drawable.pic_strawberry);
        int i = bundle.getInt("item");
        imageView.setImageResource(arrayList.get(i));
    }

}

class TabLayoutFragmentAdapter extends FragmentStatePagerAdapter {
    private Context context;
    String[] strings = {"Tab 1", "Tab 2", "Tab 3", "Tab 4"};
    int[] img = {R.drawable.pic_strawberry, R.drawable.pic_snack, R.drawable.pic_noodle, R.drawable.pic_banana};

    public TabLayoutFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return TabLayoutFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        //return TabLayoutFragment.arrayList.size();
        return 4;
    }

    //    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        switch (position) {
//            case 0: return "Tab 1";
//            case 1: return "Tab 2";
//            case 2: return "Tab 3";
//            case 3: return "Tab 4";
//        }
//        return null;
//    }
    View getTab(int layout, int position) {
        View view = LayoutInflater.from(context).inflate(layout, null);
        ImageView imageView = view.findViewById(R.id.img_view_tab_item);
        TextView textView = view.findViewById(R.id.txt_view_tab_item);
        imageView.setImageResource(img[position]);
        textView.setText(strings[position]);
        return view;
    }
}
