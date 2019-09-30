package com.mcdenny.steamshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mehdi.sakout.fancybuttons.FancyButton;

public class WhatToSellActivity extends AppCompatActivity {
    @BindView(R.id.goods_cardview)
    CardView cardViewGoods;

    @BindView(R.id.services_cardview)
    CardView cardViewServices;

    @BindView(R.id.services_layout)
    LinearLayout layoutServices;

    @BindView(R.id.goods_layout)
    LinearLayout layoutGoods;

    @BindView(R.id.img_check_services)
    ImageView imgCheckServices;

    @BindView(R.id.img_check_goods)
    ImageView imgCheckGoods;

    @BindView(R.id.goods_services_next)
    FancyButton btnNext;

    private boolean cardviewServicesClicked = false;
    private boolean cardviewGoodsClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_to_sell);
        setTitle("What to Sell");

        ButterKnife.bind(this);
    }

    @OnClick(R.id.goods_cardview)
    public void clickGoodsCardview(){
        cardviewGoodsClicked = true;
        cardviewServicesClicked =false;
        layoutGoods.setBackgroundResource(R.drawable.cardview_blue_border);
        layoutServices.setBackgroundResource(R.drawable.cardview_white_border);
        imgCheckGoods.setVisibility(View.VISIBLE);
        imgCheckServices.setVisibility(View.INVISIBLE);
        selectedWhatToSell();
    }

    @OnClick(R.id.services_cardview)
    public void clickServicesCardview(){
        cardviewServicesClicked =true;
        cardviewGoodsClicked=false;
        layoutServices.setBackgroundResource(R.drawable.cardview_blue_border);
        layoutGoods.setBackgroundResource(R.drawable.cardview_white_border);
        imgCheckServices.setVisibility(View.VISIBLE);
        imgCheckGoods.setVisibility(View.INVISIBLE);
        selectedWhatToSell();
    }

    public void selectedWhatToSell(){
        if(cardviewGoodsClicked || cardviewServicesClicked){
            btnNext.setEnabled(true);
        }
    }

    @OnClick(R.id.goods_services_next)
    public void nextButtonClicked(){
        if (cardviewGoodsClicked){
            startActivity(new Intent(this, ServiceCategories.class));
            Toast.makeText(this, "Goods and Products selected", Toast.LENGTH_SHORT).show();
        }
        else if(cardviewServicesClicked){
            Toast.makeText(this, "Services selected", Toast.LENGTH_SHORT).show();
        }
    }

}
