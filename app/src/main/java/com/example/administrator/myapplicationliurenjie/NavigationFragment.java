package com.example.administrator.myapplicationliurenjie;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;


public class NavigationFragment extends BaseFragment implements View.OnClickListener {
    LinearLayout tabTtemHome;
    LinearLayout tabTtemCategory;
    LinearLayout tabTtemCart;
    LinearLayout tabTtemPersonal;

    ImageButton tabTtemHomeBtn;
    ImageButton tabTtemCategoryBtn;
    ImageButton tabTtemCartBtn;
    ImageButton tabTtemPersonalBtn;


    private android.support.v4.app.FragmentManager framentManager;

    HomeFragment homeFragment;
    CartFragment cartFragment;
    CategoryFragment categoryFragment;
    PersonFragment personFragment;
    int currenID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        initViews(view);
        setTabSelection(R.id.tab_item_home);
        return view;
    }
    private void  initViews(View view) {
        tabTtemHome = (LinearLayout) view.findViewById(R.id.tab_item_home);
        tabTtemHome.setOnClickListener(this);
        tabTtemCategory = (LinearLayout)view.findViewById(R.id.tab_item_category);
        tabTtemCategory.setOnClickListener(this);
        tabTtemCart = (LinearLayout)view.findViewById(R.id.tab_item_cart);
        tabTtemCart.setOnClickListener(this);
        tabTtemPersonal = (LinearLayout)view.findViewById(R.id.tab_item_personal);
        tabTtemPersonal.setOnClickListener(this);
        tabTtemHomeBtn = (ImageButton)view.findViewById(R.id.tab_item_home_btn);
        tabTtemCategoryBtn = (ImageButton)view.findViewById(R.id.tab_item_category_btn);
        tabTtemCartBtn = (ImageButton)view.findViewById(R.id.tab_item_cart_btn);
        tabTtemPersonalBtn = (ImageButton)view.findViewById(R.id.tab_item_personal_btn);
        framentManager = getFragmentManager();
    }
    @Override
    public void onClick (View v){
        setTabSelection(v.getId());
    }
    public void setTabSelection ( int id){
        tabTtemHomeBtn .setImageResource(R.drawable.shouye);
        tabTtemCategoryBtn .setImageResource(R.drawable.fenlei);
        tabTtemCartBtn.setImageResource(R.drawable.gouwuche);
        tabTtemPersonalBtn .setImageResource(R.drawable.wode);
        FragmentTransaction fragmentTransaction = framentManager.beginTransaction();
        if (homeFragment!=null)
            fragmentTransaction.hide(homeFragment);
        if (categoryFragment!=null)
            fragmentTransaction.hide((categoryFragment));
        if (cartFragment!=null)
            fragmentTransaction.hide(cartFragment);
        if (personFragment!=null)
            fragmentTransaction.hide(personFragment);
        switch (id) {
            case R.id.tab_item_home:
                tabTtemHomeBtn.setImageResource(R.drawable.shouye1);
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content, homeFragment);
                } else {
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case R.id.tab_item_category:
                tabTtemCategoryBtn.setImageResource(R.drawable.fenlei1);
                if (categoryFragment == null) {
                    categoryFragment = new CategoryFragment();
                    fragmentTransaction.add(R.id.content, categoryFragment);
                } else {
                    fragmentTransaction.show(categoryFragment);
                }
                break;
            case R.id.tab_item_cart:
                tabTtemCartBtn.setImageResource(R.drawable.gouwuche1);
                if (cartFragment == null) {
                    cartFragment = new CartFragment();
                    fragmentTransaction.add(R.id.content, cartFragment);
                } else {
                    fragmentTransaction.show(cartFragment);
                }
                break;
            case R.id.tab_item_personal:
                tabTtemPersonalBtn.setImageResource(R.drawable.wode1);
                if (personFragment == null) {
                    personFragment = new PersonFragment();
                    fragmentTransaction.add(R.id.content, personFragment);
                } else {
                    fragmentTransaction.show(personFragment);
                }
                break;
        }
        fragmentTransaction.commit();
        currenID = id;


    }
}
