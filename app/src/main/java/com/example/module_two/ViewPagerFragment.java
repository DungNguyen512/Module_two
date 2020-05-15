package com.example.module_two;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class ViewPagerFragment extends Fragment {
    private static int[] proD = {R.drawable.pic_banana, R.drawable.pic_noodle, R.drawable.pic_snack, R.drawable.pic_strawberry};

    public ViewPagerFragment() {
        // Required empty public constructor
    }

    public static ViewPagerFragment newInstance(int i) {
        Bundle bundle = new Bundle();
        ViewPagerFragment fragment = new ViewPagerFragment();
        bundle.putInt("item", i);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView = (ImageView) view.findViewById(R.id.my_image_view);
        Bundle bundle = getArguments();
        int i = bundle.getInt("item");
        imageView.setImageResource(proD[i]);
    }

    public static class ViewPagerFragmentAdapter extends FragmentStatePagerAdapter {

        public ViewPagerFragmentAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return ViewPagerFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return proD.length;
        }
    }
}
