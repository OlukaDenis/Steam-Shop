package com.mcdenny.steamshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServiceCategories extends AppCompatActivity {

    public static final int MAXIMUM_SELECTED_ITEMS = 3;
    //binding ConstraintLayout
    @BindView(R.id.service_categories)
    CoordinatorLayout layout;

    //floating action button
    @BindView(R.id.done_fab)
    FloatingActionButton floatingActionButton;

    //binding CardViews
    @BindView(R.id.transport_card_view) CardView transportCardView;
    @BindView(R.id.health_card_view) CardView healthCardView;
    @BindView(R.id.home_card_view) CardView homeCardView;
    @BindView(R.id.education_card_view) CardView educationCardView;
    @BindView(R.id.fashion_card_view) CardView fashionCardView;
    @BindView(R.id.music_card_view) CardView musicCardView;
    @BindView(R.id.food_card_view) CardView foodCardView;
    @BindView(R.id.printing_card_view) CardView printingCardView;
    @BindView(R.id.multimedia_card_view) CardView multimediaCardView;
    @BindView(R.id.events_card_view) CardView eventsCardView;
    @BindView(R.id.computing_card_view) CardView computingCardView;
    @BindView(R.id.agriculture_card_view) CardView agricultureCardView;
    @BindView(R.id.business_card_view) CardView businessCardView;
    @BindView(R.id.security_card_view) CardView securityCardView;
    @BindView(R.id.technical_card_view) CardView technicalCardView;
    @BindView(R.id.real_estate_card_view) CardView realEstateCardView;

    //binding check ImageViews
    @BindView(R.id.transport_check) ImageView transportCheckView;
    @BindView(R.id.health_check) ImageView healthCheckView;
    @BindView(R.id.home_check) ImageView homeCheckView;
    @BindView(R.id.education_check) ImageView educationCheckView;
    @BindView(R.id.fashion_check) ImageView fashionCheckView;
    @BindView(R.id.music_check) ImageView musicCheckView;
    @BindView(R.id.food_check) ImageView foodCheckView;
    @BindView(R.id.printing_check) ImageView printingCheckView;
    @BindView(R.id.multimedia_check) ImageView multimediaCheckView;
    @BindView(R.id.events_check) ImageView eventsCheckView;
    @BindView(R.id.computing_check) ImageView computingCheckView;
    @BindView(R.id.agriculture_check) ImageView agricultureCheckView;
    @BindView(R.id.business_check) ImageView businessCheckView;
    @BindView(R.id.security_check) ImageView securityCheckView;
    @BindView(R.id.technical_check) ImageView technicalCheckView;
    @BindView(R.id.real_estate_check) ImageView realEstateCheckView;

    AnimatorSet checkboxAnimatorInSet;
    AnimatorSet checkboxAnimatorOutSet;
    AnimatorSet fabAnimaterInSet;
    AnimatorSet fabAnimaterOutSet;

    final String TRANSPORT_CARD_VIEW_TAG = "TRANSPORT_CARD_VIEW";
    final String HEALTH_CARD_VIEW_TAG = "HEALTH_CARD_VIEW";
    final String HOME_CARD_VIEW_TAG = "HOME_CARD_VIEW";
    final String EDUCATION_CARD_VIEW_TAG = "EDUCATION_CARD_VIEW";
    final String FASHION_CARD_VIEW_TAG = "FASHION_CARD_VIEW";
    final String MUSIC_CARD_VIEW_TAG = "MUSIC_CARD_VIEW";
    final String FOOD_CARD_VIEW_TAG = "FOOD_CARD_VIEW";
    final String PRINTING_CARD_VIEW_TAG = "PRINTING_CARD_VIEW";
    final String MULTIMEDIA_CARD_VIEW_TAG = "MULTIMEDIA_CARD_VIEW";
    final String EVENTS_CARD_VIEW_TAG = "EVENTS_CARD_VIEW";
    final String COMPUTING_CARD_VIEW_TAG = "COMPUTING_CARD_VIEW";
    final String AGRICULTURE_CARD_VIEW_TAG = "AGRICULTURE_CARD_VIEW";
    final String BUSINESS_CARD_VIEW_TAG = "BUSINESS_CARD_VIEW";
    final String SECURITY_CARD_VIEW_TAG = "SECURITY_CARD_VIEW";
    final String TECHNICAL_CARD_VIEW_TAG = "TECHNICAL_CARD_VIEW";
    final String REAL_ESTATE_CARD_VIEW_TAG = "REAL_ESTATE_CARD_VIEW";

    List<String> selectedItemsTags; //will hold currently selected categories
    boolean showFAB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_categories);

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle("Service Categories");
        }

        selectedItemsTags = new ArrayList<>();
        checkboxAnimatorInSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.check_box_in_animator);
        checkboxAnimatorOutSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.check_box_out_animator);
        fabAnimaterInSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.floating_button_animate_in);
        fabAnimaterOutSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.floating_button_animate_out);

        ButterKnife.bind(this);
        showFAB = false;
        setTags();

    }

    @OnClick({R.id.transport_card_view, R.id.health_card_view, R.id.home_card_view, R.id.education_card_view,
              R.id.fashion_card_view, R.id.music_card_view, R.id.food_card_view, R.id.printing_card_view, R.id.done_fab,
              R.id.multimedia_card_view, R.id.events_card_view, R.id.computing_card_view, R.id.agriculture_card_view,
              R.id.business_card_view, R.id.security_card_view, R.id.technical_card_view, R.id.real_estate_card_view})
    public void onCardViewClick(View view){

        switch (view.getId()){
            case R.id.transport_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS)  && !selectedItemsTags.contains(TRANSPORT_CARD_VIEW_TAG)){
                    selectedItemsTags.add(TRANSPORT_CARD_VIEW_TAG);

                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                    animateSelection(transportCheckView);


                }
                else if(selectedItemsTags.contains(TRANSPORT_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(TRANSPORT_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(transportCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }

                break;

            case R.id.health_card_view:
                //select item
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(HEALTH_CARD_VIEW_TAG)){
                  selectedItemsTags.add(HEALTH_CARD_VIEW_TAG);
                  animateSelection(healthCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                //deselect item
                else if(selectedItemsTags.contains(HEALTH_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(HEALTH_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(healthCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;

            case R.id.home_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(HOME_CARD_VIEW_TAG)){
                    selectedItemsTags.add(HOME_CARD_VIEW_TAG);
                    animateSelection(homeCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                else if(selectedItemsTags.contains(HOME_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(HOME_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(homeCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;

            case  R.id.education_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(EDUCATION_CARD_VIEW_TAG)){
                    selectedItemsTags.add(EDUCATION_CARD_VIEW_TAG);
                    animateSelection(educationCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                else if(selectedItemsTags.contains(EDUCATION_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(EDUCATION_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(educationCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;

            case R.id.fashion_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(FASHION_CARD_VIEW_TAG)){
                    selectedItemsTags.add(FASHION_CARD_VIEW_TAG);
                    animateSelection(fashionCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                else if(selectedItemsTags.contains(FASHION_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(FASHION_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(fashionCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;

            case R.id.music_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(MUSIC_CARD_VIEW_TAG)){
                    selectedItemsTags.add(MUSIC_CARD_VIEW_TAG);
                    animateSelection(musicCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                else if(selectedItemsTags.contains(MUSIC_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(MUSIC_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(musicCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;

            case R.id.food_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(FOOD_CARD_VIEW_TAG)){
                    selectedItemsTags.add(FOOD_CARD_VIEW_TAG);
                    animateSelection(foodCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                else if(selectedItemsTags.contains(FOOD_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(FOOD_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(foodCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;

            case R.id.printing_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(PRINTING_CARD_VIEW_TAG)){
                    selectedItemsTags.add(PRINTING_CARD_VIEW_TAG);
                    animateSelection(printingCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                else if(selectedItemsTags.contains(PRINTING_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(PRINTING_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(printingCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;

            case R.id.multimedia_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(MULTIMEDIA_CARD_VIEW_TAG)){
                    selectedItemsTags.add(MULTIMEDIA_CARD_VIEW_TAG);
                    animateSelection(multimediaCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                else if(selectedItemsTags.contains(MULTIMEDIA_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(MULTIMEDIA_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(multimediaCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;

            case R.id.events_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(EVENTS_CARD_VIEW_TAG)){
                    selectedItemsTags.add(EVENTS_CARD_VIEW_TAG);
                    animateSelection(eventsCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                else if(selectedItemsTags.contains(EVENTS_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(EVENTS_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(eventsCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;

            case R.id.computing_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(COMPUTING_CARD_VIEW_TAG)){
                    selectedItemsTags.add(COMPUTING_CARD_VIEW_TAG);
                    animateSelection(computingCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                else if(selectedItemsTags.contains(COMPUTING_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(COMPUTING_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(computingCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;

            case R.id.agriculture_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(AGRICULTURE_CARD_VIEW_TAG)){
                    selectedItemsTags.add(AGRICULTURE_CARD_VIEW_TAG);
                    animateSelection(agricultureCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                else if(selectedItemsTags.contains(AGRICULTURE_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(AGRICULTURE_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(agricultureCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;

            case R.id.business_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(BUSINESS_CARD_VIEW_TAG)){
                    selectedItemsTags.add(BUSINESS_CARD_VIEW_TAG);
                    animateSelection(businessCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                else if(selectedItemsTags.contains(BUSINESS_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(BUSINESS_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(businessCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;


            case R.id.security_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(SECURITY_CARD_VIEW_TAG)){
                    selectedItemsTags.add(SECURITY_CARD_VIEW_TAG);
                    animateSelection(securityCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                else if(selectedItemsTags.contains(SECURITY_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(SECURITY_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(securityCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;

            case R.id.technical_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(TECHNICAL_CARD_VIEW_TAG)){
                    selectedItemsTags.add(TECHNICAL_CARD_VIEW_TAG);
                    animateSelection(technicalCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                else if(selectedItemsTags.contains(TECHNICAL_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(TECHNICAL_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(technicalCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;

            case R.id.real_estate_card_view:
                if(!(selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS) && !selectedItemsTags.contains(REAL_ESTATE_CARD_VIEW_TAG)){
                    selectedItemsTags.add(REAL_ESTATE_CARD_VIEW_TAG);
                    animateSelection(realEstateCheckView);
                    if(!showFAB){
                        showFAB = true;
                        animateInFAB();
                    }
                }
                else if(selectedItemsTags.contains(REAL_ESTATE_CARD_VIEW_TAG)){
                    selectedItemsTags.remove(REAL_ESTATE_CARD_VIEW_TAG);
                    if(selectedItemsTags.size()==0){
                        showFAB = false;
                        animateOutFAB();
                    }
                    animateDeselection(realEstateCheckView);
                }
                else if (selectedItemsTags.size() >= MAXIMUM_SELECTED_ITEMS){
                    showSnackBar();
                }
                break;

            case R.id.done_fab:
                Snackbar.make(layout, "Done with selection", Snackbar.LENGTH_LONG).show();
                break;

        }

    }

    private void animateSelection(ImageView view){

        //first setup view before animating since its currently in GONE state
        view.setAlpha(0f);
        view.setVisibility(View.VISIBLE);
        view.setScaleX(0f);

        checkboxAnimatorInSet.setTarget(view);
        checkboxAnimatorInSet.start();

    }

    private void animateDeselection(ImageView view){
        checkboxAnimatorOutSet.setTarget(view);
        checkboxAnimatorOutSet.start();
    }

    private void showSnackBar(){
        Snackbar.make(layout, "only 3 items can be selected", Snackbar.LENGTH_LONG).show();
    }

    private void animateOutFAB(){
        fabAnimaterOutSet.setTarget(floatingActionButton);
        fabAnimaterOutSet.start();
    }

    private void animateInFAB(){

        //first setup FAB before animating since its currently in GONE state
        floatingActionButton.setAlpha(0f);
        floatingActionButton.setVisibility(View.VISIBLE);
        floatingActionButton.setScaleX(0f);
        floatingActionButton.setScaleY(0f);

        fabAnimaterInSet.setTarget(floatingActionButton);
        fabAnimaterInSet.start();
    }

    private void setTags(){
        transportCardView.setTag(TRANSPORT_CARD_VIEW_TAG);
        healthCardView.setTag(HEALTH_CARD_VIEW_TAG);
        homeCardView.setTag(HOME_CARD_VIEW_TAG);
        educationCardView.setTag(EDUCATION_CARD_VIEW_TAG);
        fashionCardView.setTag(FASHION_CARD_VIEW_TAG);
        musicCardView.setTag(MUSIC_CARD_VIEW_TAG);
        foodCardView.setTag(FOOD_CARD_VIEW_TAG);
        printingCardView.setTag(PRINTING_CARD_VIEW_TAG);
        multimediaCardView.setTag(MULTIMEDIA_CARD_VIEW_TAG);
        eventsCardView.setTag(EVENTS_CARD_VIEW_TAG);
        computingCardView.setTag(COMPUTING_CARD_VIEW_TAG);
        agricultureCardView.setTag(AGRICULTURE_CARD_VIEW_TAG);
        businessCardView.setTag(BUSINESS_CARD_VIEW_TAG);
        securityCardView.setTag(SECURITY_CARD_VIEW_TAG);
        technicalCardView.setTag(TECHNICAL_CARD_VIEW_TAG);
        realEstateCardView.setTag(REAL_ESTATE_CARD_VIEW_TAG);
    }
}
