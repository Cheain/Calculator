package com.calculator.hchhc.calculator;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by hchhc on 2016/1/31.
 */
public class EasterEgg {
    public static void easterEgg(double result, Context context) {
        String text = "";
        if ((Math.abs(result - 6.66) < 0.01) || (Math.abs(result - 666) < 1)) {
            text = "你也是666的不行哦(☞^o^) ☞";
        } else if ((Math.abs(result - 5.20) < 0.01) || (Math.abs(result - 520) < 1)) {
            text = "本宝宝也爱你么么哒(*˘︶˘*).｡.:*♡";
        } else if ((Math.abs(result - 13.14) < 0.01) || (Math.abs(result - 1314) < 1)) {
            text = "讨厌谁要跟你1314(￣へ￣)";
        } else if ((Math.abs(result - 11.11) < 0.01) || (Math.abs(result - 1111) < 1)) {
            text = "哦豁祝孤生咯╮（╯＿╰）╭";
        } else if ((Math.abs(result - 5.55) < 0.01) || (Math.abs(result - 555) < 1)) {
            text = "嘤嘤嘤ಥ_ಥ";
        } else if ((Math.abs(result - 2.22) < 0.01) || (Math.abs(result - 222) < 1)) {
            text = "你才是个二货_(:з」∠)_";
        } else if ((Math.abs(result - 2.33) < 0.01) || (Math.abs(result - 233) < 1)) {
            text = "啊哈哈哈哈(ಡωಡ)hiahiahia";
        }
        if (!text.equals("")) {
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
