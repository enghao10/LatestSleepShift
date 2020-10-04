package com.dsassignment.sleepscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MealPlanner extends AppCompatActivity {
    TextView textViewA;
    TextView textViewB;
    TextView textViewC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_planner);
        int day = 0;
        try{
            BufferedReader bufferedReader=new BufferedReader(new FileReader(new File(getFilesDir()+ File.separator+"days.txt")));
            day=Integer.parseInt(bufferedReader.readLine());

            bufferedReader.close();
        }catch(IOException e){
            Log.d("IOException",e.getMessage());
        }

        textViewA = findViewById(R.id.textView6);
        textViewB = findViewById(R.id.textView7);
        textViewC = findViewById(R.id.textView8);
        String mealA = "";
        String mealB = "";
        String mealC = "";

        if(day % 4 == 0) {
            mealA = "Meal A\n\nEggs Scrambled w/Bacon, Hash Browns, Sausage\nToast\nMargarine\nJelly, Assorted\nApple Juice\nCoffee/Tea/Cocoa";
            mealB = "Meal B\n\nChicken, over-fried\nMacaroni and Cheese\nCorn, whole kernel\nPeaches\nAlmonds\nPineapple-Grape Juice";
            mealC = "Meal C\n\nBeef Fajita\nSpanish Rice\nTortilla Chips\nPicante Sauce\nChili con Queso\nTortilla\nLemon Bar\nApple Cider";
        }
        else if (day % 4 == 1) {
            mealA = "Meal A\n\nCereal, cold\nYogurt, fruit\nBiscuit\nMargarine\nJelly, assorted\nMilk\nCranberry Juice\nCoffee/Tea/Cocoa";
            mealB = "Meal B\n\nSoup, cream of broccoli\nBeef Patty\nCheese Slice\nSandwich Bun\nPretzels\nCried Apples\nVanilla Pudding\nChocolate Instant Breakfast";
            mealC = "Meal C\n\nFish, saut ed\nTartar Sauce\nLemon Juice\nPasta Salad\nGreen Beans\nBread\nMargarine\nAngel Food Cake\nStrawberries\nOrange-Pineapple Drink";
        }
        else if(day % 4 == 2) {
            mealA = "Meal A\n\nFrench Toast\nCanadian Bacon\nMargarine\nSyrup\nOrange Juice\nCoffee/Tea/Cocoa";
            mealB = "Meal B\n\nCheese Manicotti w/Tomato Sauce\nGarlic Bread\nBerry Medley\nCookie, shortbread\nLemonade";
            mealC = "Meal C\n\nTurkey Breast, sliced\nMashed Sweet Potato\nAsparagus Tips\nCornbread\nMargarine\nPumpkin Pie\nCheery Drink";
        }
        else {
            mealA = "Meal A\n\nCereal, hot\nCinnamon Roll\nMilk\nGrape Juice\nCoffee/Tea/Cocoa";
            mealB = "Meal B\n\nQuiche Lorraine\nSeasoned Rye Krisp\nFresh Orange\nCookies, Butter";
            mealC = "Meal C\n\nSoup, won ton\nChicken Teriyaki\nChinese Vegetables, stir-fry\nEggs Rools\nHot Chinese Mustard\nSweet n Sour Sauce\nVanilla Ice Cream\nCookies, fortune\nTea";
        }
        textViewA.setText(mealA);
        textViewB.setText(mealB);
        textViewC.setText(mealC);
    }
}