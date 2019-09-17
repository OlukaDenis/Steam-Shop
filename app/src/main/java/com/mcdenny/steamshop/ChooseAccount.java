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

public class ChooseAccount extends AppCompatActivity {
    @BindView(R.id.individual_cardview)
    CardView cardViewIndividual;

    @BindView(R.id.business_cardview)
    CardView cardViewBusiness;

    @BindView(R.id.individual_layout)
    LinearLayout layoutIndividual;

    @BindView(R.id.business_layout)
    LinearLayout layoutBusiness;

    @BindView(R.id.img_check_individual)
    ImageView imgCheckIndividual;

    @BindView(R.id.img_check_business)
    ImageView imgCheckBusiness;

    @BindView(R.id.account_next)
    FancyButton btnNext;

    private boolean cardviewIndividualClicked = false;
    private boolean cardviewBusinessClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_account);
        setTitle("Choose Shop Account");

        ButterKnife.bind(this);

    }

    @OnClick(R.id.individual_cardview)
    public void clickIndividualCardview(){
        cardviewIndividualClicked = true;
        cardviewBusinessClicked =false;
        layoutIndividual.setBackgroundResource(R.drawable.cardview_blue_border);
        layoutBusiness.setBackgroundResource(R.drawable.cardview_white_border);
        imgCheckIndividual.setVisibility(View.VISIBLE);
        imgCheckBusiness.setVisibility(View.INVISIBLE);
        selectedAccount();
    }

    @OnClick(R.id.business_cardview)
    public void clickBusinessCardview(){
        cardviewBusinessClicked =true;
        cardviewIndividualClicked=false;
        layoutBusiness.setBackgroundResource(R.drawable.cardview_blue_border);
        layoutIndividual.setBackgroundResource(R.drawable.cardview_white_border);
        imgCheckIndividual.setVisibility(View.INVISIBLE);
        imgCheckBusiness.setVisibility(View.VISIBLE);
        selectedAccount();
    }

    public void selectedAccount(){
        if(cardviewIndividualClicked || cardviewBusinessClicked){
            btnNext.setEnabled(true);
        }
    }

    @OnClick(R.id.account_next)
    public void nextButtonClicked(){
        if (cardviewIndividualClicked){
            startActivity(new Intent(getApplicationContext(), WhatToSellActivity.class));
            Toast.makeText(this, "Individual Account selected", Toast.LENGTH_SHORT).show();
        }
        else if(cardviewBusinessClicked){
            Toast.makeText(this, "Business Account selected", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), WhatToSellActivity.class));
        }
    }
}
